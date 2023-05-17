package com.socialMedia.fatihGonkayali.repository;


import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.model.PostComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findByUserIdAndPostId(Long userId, Long postId);

    List<PostComment> findByPostId(Long postId);

    List<PostComment> findByUserId(Long userId);


}
