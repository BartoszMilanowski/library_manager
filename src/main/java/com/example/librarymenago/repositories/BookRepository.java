package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Author;
import com.example.librarymenago.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findById(int id);
    Optional<Book> findByIsbn(Long isbn);
    List<Book> findAllByAuthor(Author author);
    List<Book> findByTitle(String title);

}
