package com.socialMedia.fatihGonkayali.controller;

import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.requests.PostUpdateRequest;
import com.socialMedia.fatihGonkayali.requests.PostCreateRequest;
import com.socialMedia.fatihGonkayali.responses.PostResponse;
import com.socialMedia.fatihGonkayali.service.PostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
@RequestMapping("/posts")
@RestController
public class PostController {
    PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @RequestMapping("/get")
    public ModelAndView showRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("posts");
        return modelAndView;
    }
    @GetMapping
    public List<PostResponse> getAllPost(Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @PostMapping()
    public Post createPost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.saveOnePost(postCreateRequest);
    }

    @GetMapping("/{postId}")
    public Post getOneUser(@PathVariable Long postId){
        return postService.getOnePost(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.uptadeOnePost(postId, postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePost(postId);
    }
}
