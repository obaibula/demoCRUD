package com.example.demoCRUD.dao;

import com.example.demoCRUD.entity.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO{

    private EntityManager entityManager;

    @Autowired
    public PostDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Post findById(int id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public List<Post> findAll() {
        return entityManager.createQuery("FROM Post", Post.class)
                .getResultList();
    }

    @Override
    public Post save(Post post) {
        return entityManager.merge(post);
    }

    @Override
    public void deleteById(int id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }
}
