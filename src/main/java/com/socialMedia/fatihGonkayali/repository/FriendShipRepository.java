package com.socialMedia.fatihGonkayali.repository;

import com.socialMedia.fatihGonkayali.model.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FriendShipRepository extends JpaRepository<FriendShip, Long> {

    @Override
    List<FriendShip> findAll();

    List<FriendShip> findByUserAcceptAndUserQue(Long accept, Long question);
    List<FriendShip> findByUserQue(Long que);
    List<FriendShip> findByUserAccept(Long acp);


    void deleteByUserAcceptAndUserQue(Optional<Long> accept, Optional<Long>  question);
    void deleteByUserAccept(Optional<Long> accept);
    void deleteByUserQue(Optional<Long> question);
}
