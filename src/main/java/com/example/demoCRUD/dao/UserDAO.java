package com.example.demoCRUD.dao;

import com.example.demoCRUD.entity.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    List<User> findAll();

    User update(User user);

    void deleteByID(int id);
}
