package io.fg.socialmedia.model.post;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue
    private long id;

    private String profil_id;
    private long post_id;

    @Lob
    @Column(columnDefinition = "text")
    private String comment_text;
    private long created_time;
    private long update_time;

}

