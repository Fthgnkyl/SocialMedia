package io.fg.socialmedia.mapper;

import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.payload.SimpleAccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public SimpleAccountResponse toIterable(Account account) {
        return toSimple(account);
    }

    public SimpleAccountResponse toSimple(Account account) {
        return SimpleAccountResponse.builder()
                .id(account.getId())
                .username(account.getUsername())
                .disabled(account.isDisabled())
                .locked(account.isLocked())
                .build();
    }
}
