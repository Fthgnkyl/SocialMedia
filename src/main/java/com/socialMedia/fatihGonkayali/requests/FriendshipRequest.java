package com.socialMedia.fatihGonkayali.requests;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="friendship_request")
@Data
public class FriendshipRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long quest;
    Long accept;

}
