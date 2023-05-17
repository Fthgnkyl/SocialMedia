package com.socialMedia.fatihGonkayali.responses;


import com.socialMedia.fatihGonkayali.model.PostComment;
import lombok.Data;

@Data
public class CommentResponse {
    Long id;
    Long userId;
    Long postId;
    String text;

    public CommentResponse(PostComment entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postId = entity.getPost().getId();
        this.text = entity.getText();
    }
}
