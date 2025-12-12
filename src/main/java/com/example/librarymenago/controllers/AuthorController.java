package com.example.librarymenago.controllers;

import com.example.librarymenago.dto.authorDtos.AuthorDto;
import com.example.librarymenago.entities.Author;
import com.example.librarymenago.services.AuthorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public AuthorDto getAuthorById(@PathVariable int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/name/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Integer>> addAuthor(@RequestBody Author author) {
        Author addedAuthor = authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("createdId", addedAuthor.getId()));
    }

    @PutMapping("/edit/{authorId}")
    public ResponseEntity<Map<String, Integer>> updateAuthor(@PathVariable int authorId, @RequestBody Author author) {
       authorService.updateAuthor(author, authorId);
       return ResponseEntity.ok(Map.of("UpdatedId", author.getId()));
    }

}
