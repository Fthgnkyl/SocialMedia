package com.socialMedia.fatihGonkayali.repository;

import com.socialMedia.fatihGonkayali.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends JpaRepository<Admin, Long> {
}
