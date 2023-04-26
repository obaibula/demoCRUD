package com.example.demoCRUD.rest;

import com.example.demoCRUD.entity.User;
import com.example.demoCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        return requireNonNull(userService.findById(userId), "User Not Found");
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestParam User user){
        User userToAdd = requireNonNull(user);
        userToAdd.setId(0);
        return userService.update(userToAdd);
    }

    @PutMapping("/users")
    public User updateUser(@RequestParam User user){
        return userService.update(requireNonNull(user, "User Not Found"));
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable int userId){
        requireNonNull(userService.findById(userId), "User Not Found");
        userService.deleteByID(userId);

        return "Deleted user with id: " + userId;
    }
}
