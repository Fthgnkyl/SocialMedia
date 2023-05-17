package com.socialMedia.fatihGonkayali.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long userId;
    Long postId;
    String text;


}
