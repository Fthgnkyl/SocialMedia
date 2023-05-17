package com.socialMedia.fatihGonkayali.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
    String text;
    Long userId;
    String url;
}
