package io.fg.socialmedia.model.post;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name= "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long post_id;
    @NotBlank
    @NotNull
    private String profil_id;
    @NotBlank
    @NotNull
    private String text;
    private String media;
    @NotNull
    private long created_time;
    @NotNull
    private long update_time;

}
