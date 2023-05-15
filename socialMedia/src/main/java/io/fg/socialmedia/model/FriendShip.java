package io.fg.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "friendship")
@Entity
@Data
public class FriendShip {
    @Id
    private long row;
    private String request;//userID
    private String accepts;//userID

}
