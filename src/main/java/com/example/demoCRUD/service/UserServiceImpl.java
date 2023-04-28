package com.example.demoCRUD.service;

import com.example.demoCRUD.dao.UserDAO;
import com.example.demoCRUD.dto.UserDTO;
import com.example.demoCRUD.dto.UserDTOMapper;
import com.example.demoCRUD.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserDTOMapper userDTOMapper) {
        this.userDAO = userDAO;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public UserDTO findById(int id) {
        //todo: correct DAO using Optional
        return Optional.of(userDAO.findById(id))
                .map(userDTOMapper)
                .orElseThrow(() -> new RuntimeException("customer not found"));
    }

    @Override
    public List<UserDTO> findAll() {
        return userDAO.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteByID(int id) {
        userDAO.deleteByID(id);
    }
}
