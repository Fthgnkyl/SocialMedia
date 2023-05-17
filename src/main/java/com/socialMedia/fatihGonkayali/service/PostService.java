package com.socialMedia.fatihGonkayali.service;


import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.PostRepository;
import com.socialMedia.fatihGonkayali.requests.PostCreateRequest;
import com.socialMedia.fatihGonkayali.requests.PostUpdateRequest;
import com.socialMedia.fatihGonkayali.responses.CommentResponse;
import com.socialMedia.fatihGonkayali.responses.LikeResponse;
import com.socialMedia.fatihGonkayali.responses.PostResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    private LikeService likeService;
    private CommentService commentService;


    public PostService(PostRepository postRepository, UserService userService,@Lazy LikeService likeService,@Lazy CommentService commentService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.likeService = likeService;
        this.commentService = commentService;
    }


    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> postList;
        if (userId.isPresent()){
            postList = postRepository.findByUserId(userId.get());
        }
        postList = postRepository.findAll();

        return postList.stream().map(p -> {
            List<LikeResponse> likeList = likeService.getAllLikes(Optional.ofNullable(null),Optional.ofNullable(p.getId()));
            List<CommentResponse> commentList = commentService.getAllComments(Optional.ofNullable(null),Optional.ofNullable(p.getId()));
            return new PostResponse(p,likeList,commentList);
        }).collect(Collectors.toList());
    }

    public Post saveOnePost(PostCreateRequest postCreateRequest) {
        User user = userService.getOneUser(postCreateRequest.getUserId());
        if (user==null)return null;
        Post toSave = new Post();
        toSave.setText(postCreateRequest.getText());
        toSave.setUrl(postCreateRequest.getUrl());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post uptadeOnePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post foundPost = post.get();

            foundPost.setText(postUpdateRequest.getText());
            postRepository.save(foundPost);
            return foundPost;
        }else
            return null;
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
