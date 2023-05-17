package com.socialMedia.fatihGonkayali.repository;

import com.socialMedia.fatihGonkayali.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long>{
    List<User> findByUsername(String userName);
}
