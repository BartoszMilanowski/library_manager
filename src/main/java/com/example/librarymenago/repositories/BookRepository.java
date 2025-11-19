package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findById(long id);
    Optional<Book> findByTitle(String title);
}
