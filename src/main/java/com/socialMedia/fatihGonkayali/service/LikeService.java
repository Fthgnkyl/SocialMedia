package com.socialMedia.fatihGonkayali.service;


import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.model.PostLike;
import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.LikeRepository;
import com.socialMedia.fatihGonkayali.requests.LikeCreateRequest;
import com.socialMedia.fatihGonkayali.responses.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<LikeResponse> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<PostLike> likeList;
        if(userId.isPresent()&&postId.isPresent()) {
            likeList = likeRepository.findByUser_IdAndPostId(userId.get(),postId.get());
        }
        else if (postId.isPresent()){
            likeList = likeRepository.findByPost(postId.get());
        }
        else if (userId.isPresent()) {
            likeList = likeRepository.findByPost(userId.get());
        }
        else likeList = likeRepository.findAll();

        return likeList.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }
    public PostLike getOneLike(Long likeId) {
      return  likeRepository.findById(likeId).orElse(null);
    }


    public PostLike crateOneLike(LikeCreateRequest likeCreateRequest) {
        User user = userService.getOneUser(likeCreateRequest.getUserId());
        Post post = postService.getOnePost(likeCreateRequest.getPostId());

        if (user!=null&&post!=null){
            PostLike likeToSave = new PostLike();
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        }
        else return null;
    }

    public void deleteOneLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
