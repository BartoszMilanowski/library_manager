package com.example.librarymenago.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String cover;
    @ManyToMany()
    @JoinTable(name = "authors_titles",
            joinColumns = {@JoinColumn(name = "title_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
    private Long isbn;

    public Book() {
    }

    public Book(String title, String description, String cover, Set<Author> authors, Long isbn) {
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.authors = authors;
        this.isbn = isbn;
    }

    public Book(String title, String description, String cover, Long isbn, Set<Author> authors) {
        this.title = title;
        this.description = description;
        this.cover = cover;
        this.authors = authors != null ? authors : new HashSet<>();
        this.isbn = isbn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
