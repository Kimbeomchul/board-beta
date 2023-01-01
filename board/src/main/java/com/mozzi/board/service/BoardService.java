package com.mozzi.board.service;

import com.mozzi.board.domain.Board;
import com.mozzi.board.domain.type.SearchKey;
import com.mozzi.board.dto.BoardDto;
import com.mozzi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<Board> boardSearch(SearchKey searchKey, String keyword, Pageable pageable) throws Exception {
        if(searchKey == null) {
            return boardRepository.findAll(pageable);
        }
        return switch (searchKey){
            case TITLE -> boardRepository.findByTitleContaining(keyword, pageable);
            case CONTENT -> boardRepository.findByContentContaining(keyword, pageable);
            case HASHTAG -> boardRepository.findByHashtag("#" + keyword, pageable);
            case ID -> boardRepository.findById(keyword, pageable);
            default -> throw new Exception("E");
        };
    }

    @Transactional(readOnly = true)
    public Optional<Board> boardDetail(Long id) throws Exception {
        return Optional.ofNullable(boardRepository.findById(id).orElseThrow(() -> new Exception("boardDetail 에러")));
    }

    public void saveBoard(Board board){
        boardRepository.save(board);
    }

    public void updateBoard(Board board){
        Board referenceById = boardRepository.getReferenceById(board.getId());
        if(board.getTitle() != null) { referenceById.setTitle(board.getTitle()); }
        if(board.getContent() != null) { referenceById.setContent(board.getContent()); }
        referenceById.setHashtag(board.getHashtag());
        boardRepository.save(referenceById);
    }

    public void deleteBoard(long id){
        boardRepository.deleteById(id);
    }

}
