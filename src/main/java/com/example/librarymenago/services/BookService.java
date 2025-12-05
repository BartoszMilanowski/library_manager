package com.example.librarymenago.services;

import com.example.librarymenago.dto.AuthorBasicsDto;
import com.example.librarymenago.dto.BookCopiesDto;
import com.example.librarymenago.dto.BookDto;
import com.example.librarymenago.dto.BookWithCopiesDto;
import com.example.librarymenago.entities.Book;
import com.example.librarymenago.entities.BookCopy;
import com.example.librarymenago.repositories.BookCopyRepository;
import com.example.librarymenago.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookCopyRepository bookCopyRepository;

    public BookService(BookRepository bookRepository,  BookCopyRepository bookCopyRepository) {
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
    }

   public List<BookDto> getBooksDto(){
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getCover(),
                        book.getIsbn(),
                        book.getAuthors().stream()
                                .map(author -> new AuthorBasicsDto(
                                        author.getId(),
                                        author.getFirstName(),
                                        author.getLastName()
                                ))
                                .collect(Collectors.toSet())
                ))
                .toList();
   }

   public Book getBookById(int id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
   }

   public BookWithCopiesDto getBookWithCopiesDtoById(int id){
        Book book = getBookById(id);
        List<BookCopy> copies = bookCopyRepository.findByBookId(book.getId());
        return new BookWithCopiesDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCover(),
                book.getIsbn(),
                book.getAuthors().stream()
                        .map(author -> new AuthorBasicsDto(
                                author.getId(),
                                author.getFirstName(),
                                author.getLastName()
                        ))
                        .collect(Collectors.toSet()),
                copies.stream()
                        .map(copy -> new BookCopiesDto(
                                copy.getId(),
                                copy.getBarcode(),
                                copy.getStatus()
                        ))
                        .collect(Collectors.toSet())
        );
   }

   public BookDto getBookDtoById(int id){
        Book book = getBookById(id);
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCover(),
                book.getIsbn(),
                book.getAuthors().stream()
                        .map(author -> new AuthorBasicsDto(
                                author.getId(),
                                author.getFirstName(),
                                author.getLastName()
                        ))
                        .collect(Collectors.toSet())
        );

   }

   public Book getBookByIsbn(Long isbn){
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
   }

   public BookDto getBookDtoByIsbn(Long isbn){
        Book book = getBookByIsbn(isbn);
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCover(),
                book.getIsbn(),
                book.getAuthors().stream()
                        .map(author -> new AuthorBasicsDto(
                                author.getId(),
                                author.getFirstName(),
                                author.getLastName()
                        ))
                        .collect(Collectors.toSet())
        );
   }

   public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
   }

   public  List<BookDto> getBookDtoByTitle(String title) {

        return findByTitle(title).stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getCover(),
                        book.getIsbn(),
                        book.getAuthors().stream()
                                .map(author -> new AuthorBasicsDto(
                                        author.getId(),
                                        author.getFirstName(),
                                        author.getLastName()
                                ))
                                .collect(Collectors.toSet())
                ))
                .toList();
   }


   public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
