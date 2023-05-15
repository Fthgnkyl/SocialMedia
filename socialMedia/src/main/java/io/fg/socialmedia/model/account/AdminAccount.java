package io.fg.socialmedia.model.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "admin_account")
@EqualsAndHashCode(callSuper = true)
public class AdminAccount extends Account {

}
