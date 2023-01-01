package com.mozzi.board.repository;

import com.mozzi.board.domain.Board;
import com.mozzi.board.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board, Long>{

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);
    Page<Board> findByContentContaining(String keyword, Pageable pageable);
    Page<Board> findByHashtag(String keyword, Pageable pageable);
    Page<Board> findById(String keyword, Pageable pageable);
}