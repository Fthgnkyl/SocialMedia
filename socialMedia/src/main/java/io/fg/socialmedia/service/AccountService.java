package io.fg.socialmedia.service;

import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account create(Supplier<Account> accountSupplier) {
        Account account = accountSupplier.get();
        if (accountRepository.existsByUsername(account.getUsername()))
            throw new RuntimeException("Username already exists");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setCreatedAt(System.currentTimeMillis());
        return accountRepository.save(account);
    }
}
