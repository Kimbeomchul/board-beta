package com.mozzi.board.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;


@Data
public class BoardDetailDto {

    private final String title;
    private final String content;
    private final String hashtag;
    private final Set<CommentDto> commentDtos;

    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

}
