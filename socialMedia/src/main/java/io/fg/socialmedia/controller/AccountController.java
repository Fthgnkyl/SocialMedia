package io.fg.socialmedia.controller;

import io.fg.socialmedia.mapper.AccountMapper;
import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<?> get() {
        List<Account> accounts = accountService.getAll();
        return ResponseEntity.ok(accounts.stream().map(accountMapper::toIterable).toList());
    }
}
