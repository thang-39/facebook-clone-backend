package com.example.facebookClone.service;

import com.example.facebookClone.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
