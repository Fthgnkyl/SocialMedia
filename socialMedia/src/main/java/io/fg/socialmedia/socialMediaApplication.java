package io.fg.socialmedia;

import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class socialMediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(socialMediaApplication.class, args);
    }
}
