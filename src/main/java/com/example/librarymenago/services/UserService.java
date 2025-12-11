package com.example.librarymenago.services;

import com.example.librarymenago.entities.User;
import com.example.librarymenago.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RentService rentService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,  RentService rentService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rentService = rentService;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findByLastNameIgnoreCaseContaining(lastName);
    }


    public User addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(int id, @RequestBody User user) {
        User currentUser = getUserById(id);

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setRole(user.getRole());

        return userRepository.save(currentUser);
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        if(!rentService.findByUserId(id).isEmpty()){
        throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "User has rents"
        );
        }

        userRepository.deleteById(id);
    }
}
