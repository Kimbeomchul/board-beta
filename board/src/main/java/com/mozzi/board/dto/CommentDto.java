package com.mozzi.board.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.mozzi.board.domain.Comment} entity
 */
@Data
public class CommentDto implements Serializable {
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;
    private final String content;
}