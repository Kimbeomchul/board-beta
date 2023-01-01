package com.mozzi.board.controller;


import com.mozzi.board.domain.Board;
import com.mozzi.board.dto.BoardDto;
import com.mozzi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public List<Board> board() throws Exception {
        return boardService.boardSearch(null,"", Pageable.ofSize(20)).stream().toList();
    }

    @PostMapping("/board")
    public void board(Board board) throws Exception {
        boardService.saveBoard(board);
    }

}
