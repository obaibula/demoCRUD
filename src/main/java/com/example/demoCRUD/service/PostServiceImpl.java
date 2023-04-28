package com.example.demoCRUD.service;

import com.example.demoCRUD.dao.PostDAO;
import com.example.demoCRUD.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostDAO postDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public Post findById(int id) {
        return postDAO.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    @Transactional
    public Post save(Post post) {
        return postDAO.save(post);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        postDAO.deleteById(id);
    }
}
