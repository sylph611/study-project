package com.sylph.study.studyproject.domain;

import com.sylph.study.studyproject.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private long id;

    @Comment("게시글 제목")
    private String title;

    @Comment("게시글 내용")
    private String content;
}
