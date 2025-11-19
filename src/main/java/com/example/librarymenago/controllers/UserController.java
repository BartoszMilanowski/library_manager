package com.example.librarymenago.controllers;

import com.example.librarymenago.entities.User;
import com.example.librarymenago.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{userEmail}")
    public User getUserByEmail(@PathVariable("userEmail") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
