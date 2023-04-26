package com.example.demoCRUD.service;

import com.example.demoCRUD.dao.UserDAO;
import com.example.demoCRUD.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteByID(int id) {
        userDAO.deleteByID(id);
    }
}
