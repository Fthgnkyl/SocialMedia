package io.fg.socialmedia.model.account;


import io.fg.socialmedia.model.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Account extends Entity {

    @Column(unique = true)
    private String username;
    private String password;
    @NotNull(message = "Status should be selected")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<String> roles;
    private boolean disabled;
    private boolean locked;
}
