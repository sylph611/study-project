package com.sylph.study.studyproject.repository;

import com.sylph.study.studyproject.config.JpaConfig;
import com.sylph.study.studyproject.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public JpaRepositoryTest(
            @Autowired PostRepository postRepository,
            @Autowired PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {

        // Given

        // When
        List<Post> posts = postRepository.findAll();

        // Then
        assertThat(posts)
                .isNotNull()
                .hasSize(1);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = postRepository.count();
        Post post = Post.of("new Post","Content");

        // When
        Post savedPost = postRepository.save(post);

        // Then
        assertThat(postRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Post post = postRepository.findById(1L).orElseThrow();
        String update = "updateTitle";
        post.setTitle("updateTitle");

        // When
        Post savedPost = postRepository.saveAndFlush(post);

        // Then
        assertThat(savedPost).hasFieldOrPropertyWithValue("title", update);
    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // Given
        Post post = postRepository.findById(1L).orElseThrow();
        long previoustPostCount = postRepository.count();

        // When
        postRepository.delete(post);

        // Then
        assertThat(postRepository.count()).isEqualTo(previoustPostCount-1);
    }
}