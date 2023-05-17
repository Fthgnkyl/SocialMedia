package com.socialMedia.fatihGonkayali.service;


import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.FriendshipRequestRepository;
import com.socialMedia.fatihGonkayali.requests.FriendshipRequest;
import com.socialMedia.fatihGonkayali.requests.FriendshipRequestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipRequestService {

    private FriendshipRequestRepository friendshipRequestRepository;
    private UserService userService;

    @Autowired
    public FriendshipRequestService(FriendshipRequestRepository friendshipRequestRepository, UserService userService) {
        this.friendshipRequestRepository = friendshipRequestRepository;
        this.userService = userService;
    }


    public List<FriendshipRequest> getAllRequests(Optional<Long> senderId, Optional<Long> receiveId) {
        if(senderId.isPresent()&&receiveId.isPresent()){
            return friendshipRequestRepository.findByQuestAndAccept(senderId,receiveId);
        }
        else if (senderId.isPresent())
            return friendshipRequestRepository.findByAccept(senderId.get());
        else if (receiveId.isPresent())
            return friendshipRequestRepository.findByQuest(receiveId.get());
        else return friendshipRequestRepository.findAll();}

    public FriendshipRequest getOneRequest(Long friendshipRequestId) {return friendshipRequestRepository.findById(friendshipRequestId).orElse(null);}
    public FriendshipRequest createOneRequest(FriendshipRequestCreateRequest request) {

        User quest = userService.getOneUser(request.getQuest());
        User accept = userService.getOneUser(request.getAccept());
        if (quest!=null&&accept!=null){
            FriendshipRequest requestToSave = new FriendshipRequest();
            requestToSave.setQuest(request.getQuest());
            requestToSave.setAccept(request.getAccept());
            return friendshipRequestRepository.save(requestToSave);
        }
        else return null;
    }


    public void deleteRequests(Optional <Long> accept, Optional<Long> quest, Optional<Long> receiveId) {

        if (accept.isPresent()&&quest.isPresent()&&receiveId.isPresent()){
            friendshipRequestRepository.deleteById(accept.get());

        }else if (receiveId.isPresent()&&quest.isPresent()){
            friendshipRequestRepository.deleteByQuestAndAccept(quest,receiveId);

        } else if (receiveId.isPresent()) {
            friendshipRequestRepository.deleteByAccept(accept);

        } else if (quest.isPresent()) {
            friendshipRequestRepository.deleteByQuest(quest);

        } else if (quest.isPresent())friendshipRequestRepository.deleteById(quest.get());}
}
