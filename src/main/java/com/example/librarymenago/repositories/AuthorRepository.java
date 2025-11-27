package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findById(int id);
    List<Author> findByLastNameIgnoreCaseContaining(String lastName);


}
