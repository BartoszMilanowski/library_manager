package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.BookDto;
import com.example.librarymenago.dto.BookWithCopiesDto;
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

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


}
