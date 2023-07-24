package com.sylph.study.studyproject.domain;

import com.sylph.study.studyproject.base.BaseEntity;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

public class PostComment extends BaseEntity {
    @Comment("PK")
    private long id;
    @Comment("게시글")
    private Post post;
    @Comment("내용")
    private String content;
}
