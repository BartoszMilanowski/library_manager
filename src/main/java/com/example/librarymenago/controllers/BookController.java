package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.bookDtos.BookDto;
import com.example.librarymenago.dto.bookDtos.BookWithAuthorIdDto;
import com.example.librarymenago.dto.bookDtos.BookWithCopiesDto;
import com.example.librarymenago.entities.Book;
import com.example.librarymenago.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getBooks(){
        return bookService.getBooksDto();
    }

    @GetMapping("/{bookId}")
    public BookDto getBookById(@PathVariable int bookId){
        return bookService.getBookDtoById(bookId);
    }

    @GetMapping("/{bookId}/copies")
    public BookWithCopiesDto getBookCopies(@PathVariable int bookId){
        return bookService.getBookWithCopiesDtoById(bookId);
    }

    @GetMapping("/isbn/{isbn}")
    public BookDto getBookByIsbn(@PathVariable Long isbn){
        return bookService.getBookDtoByIsbn(isbn);
    }

    @GetMapping("/title/{title}")
    public List<BookDto> getBookByTitle(@PathVariable String title){
        return bookService.getBookDtoByTitle(title);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Integer>> createBook(@RequestBody BookWithAuthorIdDto book){

        Book createdBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("createdId", createdBook.getId()));
    }

    @PutMapping("/edit/{bookId}")
    public ResponseEntity<Map<String, Integer>> updateBook(@PathVariable int bookId, @RequestBody BookWithAuthorIdDto book){
        bookService.updateBook(bookId, book);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("updatedId", bookId));
    }




}
