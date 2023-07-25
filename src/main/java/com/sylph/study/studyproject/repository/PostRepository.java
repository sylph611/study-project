package com.sylph.study.studyproject.repository;

import com.sylph.study.studyproject.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}