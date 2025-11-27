package com.example.librarymenago.controllers;

import com.example.librarymenago.entities.Author;
import com.example.librarymenago.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/name/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable("lastName") String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }
}
