package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
