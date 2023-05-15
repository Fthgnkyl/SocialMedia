package io.fg.socialmedia.model.post;

import io.fg.socialmedia.model.enums.LikeStatus;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "post_like")
public class PostLike {

    @Id
    @GeneratedValue
    private long id;
    private String profil_id;

    private long post_id;
    private String comment_text;
    private Enum<LikeStatus> likeStatusEnum;

    @Transient
    long like;
    @Transient
    long dislike;

}
