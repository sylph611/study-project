package com.sylph.study.studyproject.domain;

import com.sylph.study.studyproject.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;


@Entity
@Getter
@ToString
@Table(name = "post_comment", indexes = {
//        @Index(columnList = "title")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private long id;

    @ManyToOne(optional = false)
    private Post post;

    @Comment("내용")
    @Column(nullable = false, length = 500)
    private String content;

    @Builder
    private PostComment(long id, Post post, String content) {
        this.id = id;
        this.post = post;
        this.content = content;
    }

    public static PostComment of(Post post, String content) {
        return PostComment.builder()
                .post(post)
                .content(content)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
