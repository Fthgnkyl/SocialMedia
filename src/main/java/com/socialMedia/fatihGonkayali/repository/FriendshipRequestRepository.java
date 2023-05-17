package com.socialMedia.fatihGonkayali.repository;


import com.socialMedia.fatihGonkayali.requests.FriendshipRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FriendshipRequestRepository extends JpaRepository<FriendshipRequest, Long> {
    List<FriendshipRequest> findByQuest(Long quest);

    List<FriendshipRequest> findByQuestAndAccept(Optional<Long> quest, Optional<Long> accept);

    List<FriendshipRequest> findByAccept(Long accept);

    void deleteByQuestAndAccept(Optional<Long> quest, Optional<Long> accept);

    void deleteByAccept(Optional<Long> accept);

    void deleteByQuest(Optional<Long> quest);
}
