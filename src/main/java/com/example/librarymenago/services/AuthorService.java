package com.example.librarymenago.services;

import com.example.librarymenago.dto.AuthorDto;
import com.example.librarymenago.dto.BookBasicDto;
import com.example.librarymenago.entities.Author;
import com.example.librarymenago.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorDto> getAuthorsDto() {
        return authorRepository.findAll().stream()
                .map(author -> new AuthorDto(
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBio(),
                        author.getBooks().stream()
                                .map(book -> new BookBasicDto(
                                        book.getId(),
                                        book.getTitle(),
                                        book.getCover()
                                ))
                                .collect(Collectors.toSet())
                ))
                .toList();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }

    public List<Author> getAuthorsByLastName(String lastName) {
        return authorRepository.findByLastNameIgnoreCaseContaining(lastName);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }


}
