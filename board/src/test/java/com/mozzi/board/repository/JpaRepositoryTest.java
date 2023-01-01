package com.mozzi.board.repository;

import com.mozzi.board.config.JpaConfig;
import com.mozzi.board.domain.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import(JpaConfig.class)
@DisplayName("JPA 연결 테스트")
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void selectTest(){
        // given

        // when
        List<Board> boardList = boardRepository.findAll();

        // then
        Assertions.assertThat(boardList).isNotNull().hasSize(0);
    }
}