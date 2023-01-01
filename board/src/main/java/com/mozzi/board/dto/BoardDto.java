package com.mozzi.board.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.mozzi.board.domain.Board} entity
 */
@Data
@Builder
public class BoardDto implements Serializable {
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;
    private final String title;
    private final String content;
    private final String hashtag;

}