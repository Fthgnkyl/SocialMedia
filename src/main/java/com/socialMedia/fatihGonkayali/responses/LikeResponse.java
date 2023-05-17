package com.socialMedia.fatihGonkayali.responses;


import com.socialMedia.fatihGonkayali.model.PostLike;
import lombok.Data;

@Data
public class LikeResponse {
    Long id;
    Long userId;
    Long postId;


    public LikeResponse(PostLike entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postId = entity.getPost().getId();
    }
}
