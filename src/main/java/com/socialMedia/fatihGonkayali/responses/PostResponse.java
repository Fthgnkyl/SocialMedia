package com.socialMedia.fatihGonkayali.responses;


import com.socialMedia.fatihGonkayali.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;

    String image_url;

    String video_url;
    List<LikeResponse> likeList;

    List<CommentResponse> commentList;


    public PostResponse(Post entity, List<LikeResponse> likeList, List<CommentResponse> commentList) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.text = entity.getText();
        this.image_url = entity.getUrl();
        this.likeList = likeList;
        this.commentList = commentList;
    }
}
