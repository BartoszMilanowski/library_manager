package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Book;
import com.example.librarymenago.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface TitleRepository extends JpaRepository<Title,Integer> {

    Optional<Title> findById(long id);
    Optional<Title> findByTitle(String title);
    Optional<Title> findByIsbn(String isbn);
    Optional<Title> findByAuthor(String author);
}
