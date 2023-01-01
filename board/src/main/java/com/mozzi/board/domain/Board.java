package com.mozzi.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Entity
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@NoArgsConstructor
public class Board extends BaseFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Setter
    @Column(nullable = false, length = 5000)
    private String content; // 내용

    @Setter
    @Column(nullable = false, length = 10)
    private String hashtag; // 태그

    @OrderBy("id")
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private final Set<Comment> comments = new LinkedHashSet<>();

    public Board(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board board)) return false;
        return id != null && id.equals(board.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
