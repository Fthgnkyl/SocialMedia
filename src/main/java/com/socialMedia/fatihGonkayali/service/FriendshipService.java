package com.socialMedia.fatihGonkayali.service;


import com.socialMedia.fatihGonkayali.model.FriendShip;
import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.FriendShipRepository;
import com.socialMedia.fatihGonkayali.repository.UserRepository;
import com.socialMedia.fatihGonkayali.requests.FriendshipCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {
    private FriendShipRepository repository;
    private UserService userService;
    private UserRepository userRepository;

    public FriendshipService(FriendShipRepository repository, UserService userService,UserRepository userRepository) {
        this.repository = repository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<FriendShip> getAllFriends(Long userId) {
        User user = userService.getOneUser(userId);
        List<FriendShip> list=new ArrayList<>();
        for (FriendShip friendship : repository.findAll()){
            if (friendship.getUserQue().getId()==user.getId()||friendship.getUserAccept().getId()==user.getId()){
                list.add(friendship);
            }
        }
        return list;
    }

    public FriendShip createFriendship(FriendshipCreateRequest request) {
        FriendShip _friendship = new FriendShip();

        User userQue = userRepository.findById(request.getQuest())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getQuest()));
        User userAccept = userRepository.findById(request.getAccept())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getAccept()));

        _friendship.setUserQue(userQue);
        _friendship.setUserAccept(userAccept);

        return repository.save(_friendship);
    }

    public void deleteFriendship(Long friendshipId) {repository.deleteById(friendshipId);}
}
