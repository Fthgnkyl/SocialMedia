package com.socialMedia.fatihGonkayali.service;


import com.socialMedia.fatihGonkayali.model.Post;
import com.socialMedia.fatihGonkayali.model.PostComment;
import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.CommentRepository;
import com.socialMedia.fatihGonkayali.requests.CommentCreateRequest;
import com.socialMedia.fatihGonkayali.requests.CommentUpdateRequest;
import com.socialMedia.fatihGonkayali.responses.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<CommentResponse> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<PostComment> commentList;
        if(userId.isPresent()&&postId.isPresent()) {
            commentList = commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }
        else if (postId.isPresent()){
            commentList = commentRepository.findByPostId(postId.get());
        }
        else if (userId.isPresent()) {
            commentList = commentRepository.findByUserId(userId.get());
        }
        else commentList = commentRepository.findAll();

        return commentList.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }


    public PostComment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public PostComment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUser(commentCreateRequest.getUserId());
        Post post = postService.getOnePost(commentCreateRequest.getPostId());

        if (user!=null&&post!=null){
            PostComment commentToSave = new PostComment();
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentCreateRequest.getText());
            return commentRepository.save(commentToSave);
        }
        else return null;

    }

    public PostComment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<PostComment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            PostComment commentToUpdate= comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return  commentRepository.save(commentToUpdate);
        }

        else return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
