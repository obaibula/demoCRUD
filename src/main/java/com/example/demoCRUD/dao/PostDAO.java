package com.example.demoCRUD.dao;

import com.example.demoCRUD.entity.Post;

import java.util.List;

public interface PostDAO {
    Post findById(int id);
    List<Post> findAll();

    Post save(Post post);

    void deleteById(int id);
}
