package com.example.demoCRUD.service;

import com.example.demoCRUD.entity.Post;

import java.util.List;

public interface PostService {
    Post findById(int id);
    List<Post> findAll();

    Post save(Post post);

    void deletebyId(int id);
}
