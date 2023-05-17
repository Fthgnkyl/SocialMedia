package com.socialMedia.fatihGonkayali.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    Long userId;
    Long postId;
}
