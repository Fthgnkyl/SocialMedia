package io.fg.socialmedia.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleAccountResponse {
    private String id;
    private String username;
    private boolean disabled;
    private boolean locked;
}
