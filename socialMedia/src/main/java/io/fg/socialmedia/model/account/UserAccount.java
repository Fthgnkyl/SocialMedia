package io.fg.socialmedia.model.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@MappedSuperclass
@Table (name = "usser_account")
public class UserAccount extends Account {

    private String fullName;
    private String phoneNumber;
}
