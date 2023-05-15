package io.fg.socialmedia.service;

import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.payload.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AccountService accountService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public String getToken(SignInRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new RuntimeException("AuthService.getToken.DisabledException");
        } catch (LockedException e) {
            throw new RuntimeException("AuthService.getToken.LockedException");
        } catch (BadCredentialsException e) {
            throw new RuntimeException("AuthService.getToken.BadCredentialsException");
        } catch (Exception e) {
            throw new RuntimeException("AuthService.getToken.Exception");
        }

        Account account = accountService.getByUsername(request.getUsername());
        return jwtTokenProvider.createToken(account);
    }
}
