package com.socialMedia.fatihGonkayali.repository;

import com.socialMedia.fatihGonkayali.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface LikeRepository extends JpaRepository<PostLike, Long> {
    @Override
    List<PostLike> findAll();
    List<PostLike> findByUser_IdAndPostId(Long userId, Long PostId);
    List<PostLike> findByPost(Long postId);
    List<PostLike> findByUser_Id(Long userId);
}
