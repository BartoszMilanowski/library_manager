package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
