package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.BookDto;
import com.example.librarymenago.entities.Book;
import com.example.librarymenago.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable Long isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


}
