package com.example.librarymenago.controllers;

import com.example.librarymenago.entities.User;
import com.example.librarymenago.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
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
    public User getUserById(@PathVariable("userId") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{userEmail}")
    public User getUserByEmail(@PathVariable("userEmail") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/lastName/{lastName}")
    public List<User> getUsersByLastName(@PathVariable("lastName") String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    @PostMapping
    public ResponseEntity<Map<String, Integer>> addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("createdId", addedUser.getId()));
    }

    @PutMapping("/edit/{userId}")
    public ResponseEntity<Map<String, Integer>> updateUser(@PathVariable("userId") int id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(Map.of("updatedId", id));

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }



}
