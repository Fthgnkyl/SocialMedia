package com.socialMedia.fatihGonkayali.repository;

import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTopByUserId(Long userId);
    List<Post> findByUserId(Long userId);
}
