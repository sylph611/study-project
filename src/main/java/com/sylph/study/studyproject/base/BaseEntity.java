package com.sylph.study.studyproject.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Comment("생성일시")
    private LocalDateTime createdDate;

    @Comment("생성자")
    private Long createdBy;

    @UpdateTimestamp
    @Comment("수정일시")
    private LocalDateTime updatedDate;

    @Comment("수정자")
    private Long updatedBy;

}
