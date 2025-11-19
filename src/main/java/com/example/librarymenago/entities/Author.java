package com.example.librarymenago.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String bio;
    @ManyToMany(mappedBy = "authors")
    private Set<Title> titles;

    public Author() {
    }

    public Author(String firstName, String lastName, String bio, Set<Title> titles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.titles = titles;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }
}
