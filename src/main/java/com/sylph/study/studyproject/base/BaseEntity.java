package com.sylph.study.studyproject.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    @Comment("생성일시")
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Comment("생성자")
    @Column(nullable = false)
    private String createdBy;

    @UpdateTimestamp
    @Comment("수정일시")
    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @Comment("수정자")
    @Column(nullable = false)
    private String updatedBy;

}
