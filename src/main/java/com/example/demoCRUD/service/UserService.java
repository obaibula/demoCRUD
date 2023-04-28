package com.example.demoCRUD.service;

import com.example.demoCRUD.dto.UserDTO;
import com.example.demoCRUD.entity.User;

import java.util.List;

public interface UserService {
        UserDTO findById(int id);
        List<UserDTO> findAll();

        User save(User user);

        void deleteByID(int id);
}
