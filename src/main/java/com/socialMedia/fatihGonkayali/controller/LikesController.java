package com.socialMedia.fatihGonkayali.controller;

import com.socialMedia.fatihGonkayali.model.PostLike;
import com.socialMedia.fatihGonkayali.requests.LikeCreateRequest;
import com.socialMedia.fatihGonkayali.responses.LikeResponse;
import com.socialMedia.fatihGonkayali.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/likes")
@RestController
public class LikesController {

    private LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLikes(userId,postId);
    }

    @GetMapping("/{likeId}")
    public PostLike getOneLike(@PathVariable Long likeId){
        return likeService.getOneLike(likeId);
    }

    @PostMapping
    public PostLike createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.crateOneLike(likeCreateRequest);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteOneLike(likeId);
    }
}
