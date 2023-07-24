package com.sylph.study.studyproject.domain;

import com.sylph.study.studyproject.base.BaseEntity;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

public class Post extends BaseEntity {
    @Comment("PK")
    private long id;
    @Comment("게시글 제목")
    private String title;
    @Comment("게시글 내용")
    private String content;
}
