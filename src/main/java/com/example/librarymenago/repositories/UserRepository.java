package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {

    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);

}
