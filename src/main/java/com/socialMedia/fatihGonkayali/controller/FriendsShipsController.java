package com.socialMedia.fatihGonkayali.controller;

import com.socialMedia.fatihGonkayali.model.FriendShip;
import com.socialMedia.fatihGonkayali.requests.FriendshipCreateRequest;
import com.socialMedia.fatihGonkayali.service.FriendshipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/fri")
@RestController
public class FriendsShipsController {

    FriendshipService service;

    public FriendsShipsController(FriendshipService service) {this.service = service;}

    @GetMapping("{userId}")
    public List<FriendShip> getAllFriendships(@PathVariable Long userId ){
        return service.getAllFriends(userId);
    }

    @PostMapping
    public FriendShip createFriendship(@RequestBody FriendshipCreateRequest request){
        return service.createFriendship(request);
    }

    @DeleteMapping
    public void deleteFriendship(@PathVariable Long friendshipId){service.deleteFriendship(friendshipId);}
}
