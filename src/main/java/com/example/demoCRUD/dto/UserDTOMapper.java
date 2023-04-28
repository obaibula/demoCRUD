package com.example.demoCRUD.dto;

import com.example.demoCRUD.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getBio(),
                user.getAvatar(),
                user.getPhone(),
                user.getEmail(),
                user.getPosts()
                        .stream()
                        .map(p -> String.valueOf(p.getId()))
                        .collect(Collectors.toList()));
    }
}
