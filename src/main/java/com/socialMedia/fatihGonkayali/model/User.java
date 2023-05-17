package com.socialMedia.fatihGonkayali.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Entity
@Data
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "Özel karekter kullanılamaz")
    @NotBlank(message = "Username cannot be white space or empty")
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Email
    @NotBlank(message = "Email cannot be white space or empty")
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @NotBlank
    @NotNull(message = "Name cannot be white space or empty")
    private String name;
    @NotBlank
    @NotNull(message = "Lastname cannot be white space or empty")
    private String lastName;
    @NotBlank
    @NotNull(message = "Password cannot be white space or empty")
    private String password;
    @Transient
    private String fullName;
    @NotBlank
    @NotNull(message = "Country cannot be white space or empty")
    private String country;
    private String gender;

    private String description;



}
