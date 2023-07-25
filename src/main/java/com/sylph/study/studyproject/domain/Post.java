package com.sylph.study.studyproject.domain;

import com.sylph.study.studyproject.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Entity
@Getter
@ToString
@Table(name = "post", indexes = {
//        @Index(columnList = "title")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private long id;

    @Comment("게시글 제목")
    @Column(nullable = false, length = 1000)
    private String title;

    @Comment("게시글 내용")
    @Column(nullable = false, length = 1000)
    private String content;

    @Builder
    public Post(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static Post of(String title, String content) {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
