package com.example.librarymenago.repositories;

import com.example.librarymenago.entities.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {

    List<BookCopy> findByBookId(int bookId);

}
