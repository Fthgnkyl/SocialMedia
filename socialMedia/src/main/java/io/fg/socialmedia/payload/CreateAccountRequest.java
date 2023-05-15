package io.fg.socialmedia.payload;

import io.fg.socialmedia.model.account.UserAccount;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;
import java.util.function.Supplier;

@Data
public class CreateAccountRequest implements Supplier<UserAccount> {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 55)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 55)
    private String password;

    @Size(min = 3, max = 55)
    private String fullName;

    @Size(min = 7, max = 15)
    private String phoneNumber;

    @Override
    public UserAccount get() {
        UserAccount account = new UserAccount();
        account.setUsername(getUsername());
        account.setPassword(getPassword());
        account.setRoles(Set.of("ROLE_USER"));
        account.setDisabled(false);
        account.setLocked(false);
        account.setFullName(getFullName());
        account.setPhoneNumber(getPhoneNumber());
        return account;
    }

}
