package com.socialMedia.fatihGonkayali.responses;


import com.socialMedia.fatihGonkayali.model.User;
import lombok.Data;

@Data
public class UserResponse {

    Long id;

    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.userName = entity.getUsername();
    }
}