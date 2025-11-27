package com.example.librarymenago.entities;

import jakarta.persistence.*;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    private Book book;
    private boolean isRent;
    private boolean isReserved;

    public BookCopy() {
    }

    public BookCopy(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getTitle() {
        return book;
    }

    public void setTitle(Book book) {
        this.book = book;
    }

    public boolean getIsRent() {
        return isRent;
    }

    public void setIsRent(boolean rent) {
        isRent = rent;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean reserved) {
        isReserved = reserved;
    }
}
