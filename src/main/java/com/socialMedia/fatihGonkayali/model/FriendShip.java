package com.socialMedia.fatihGonkayali.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Data
@Table(name = "friendship")
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "que_user_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    User userQue;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_user_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    User userAccept;
}
