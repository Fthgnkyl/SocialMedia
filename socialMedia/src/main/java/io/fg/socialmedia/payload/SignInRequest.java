package io.fg.socialmedia.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 55)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 55)
    private String password;
}
