package io.fg.socialmedia.repository;



import io.fg.socialmedia.model.account.Account;
import io.fg.socialmedia.model.account.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    boolean existsByUsername(String username);

    Optional<UserAccount> findByUsername(String username);
}
