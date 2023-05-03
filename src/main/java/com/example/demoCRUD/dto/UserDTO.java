package com.example.demoCRUD.dto;

import com.example.demoCRUD.entity.Post;
import com.example.demoCRUD.entity.UserStatus;

import java.util.List;

public record UserDTO(int id,
                      String username,
                      String bio,
                      String avatar,
                      String phone,
                      String email,
                      UserStatus status,
                      List<String> posts) {
}
