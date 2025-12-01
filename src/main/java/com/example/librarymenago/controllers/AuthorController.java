package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.AuthorDto;
import com.example.librarymenago.entities.Author;
import com.example.librarymenago.services.AuthorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthorsDto();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/name/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable("lastName") String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
}
