package com.socialMedia.fatihGonkayali.service;

import com.socialMedia.fatihGonkayali.model.PostComment;
import com.socialMedia.fatihGonkayali.model.User;
import com.socialMedia.fatihGonkayali.repository.CommentRepository;
import com.socialMedia.fatihGonkayali.repository.LikeRepository;
import com.socialMedia.fatihGonkayali.repository.PostRepository;
import com.socialMedia.fatihGonkayali.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    LikeRepository likeRepository;
    CommentRepository commentRepository;
    PostRepository postRepository;

    public UserService(UserRepository userRepository, LikeRepository likeRepository,
                       CommentRepository commentRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setName(newUser.getName());
            foundUser.setLastName(newUser.getLastName());
            foundUser.setFullName(newUser.getName()+" "+newUser.getLastName());
            foundUser.setCountry(newUser.getCountry());
            foundUser.setGender(newUser.getGender());
            foundUser.setDescription(newUser.getDescription());
            userRepository.save(foundUser);
            return foundUser;
        }else
            return null;
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User getOneUserByUserName(String userName) {
        return (User) userRepository.findByUsername(userName);
    }


}
