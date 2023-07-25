package com.sylph.study.studyproject.repository;

import com.sylph.study.studyproject.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}