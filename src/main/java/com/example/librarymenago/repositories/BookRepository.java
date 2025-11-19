package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
