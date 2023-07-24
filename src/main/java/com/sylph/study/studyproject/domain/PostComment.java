package com.sylph.study.studyproject.domain;

import java.time.LocalDateTime;

public class PostComment {
    private long id;
    private Post post;
    private String content;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
