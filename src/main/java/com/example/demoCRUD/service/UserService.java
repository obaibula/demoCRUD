package com.example.demoCRUD.service;

import com.example.demoCRUD.entity.User;

import java.util.List;

public interface UserService {
        User findById(int id);
        List<User> findAll();

        User save(User user);

        void deleteByID(int id);
}
