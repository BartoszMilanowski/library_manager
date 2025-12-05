package com.example.librarymenago.entities;

import jakarta.persistence.*;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    private String barcode;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCopyStatus status;

    public BookCopy(Book book, String barcode, BookCopyStatus status) {
        this.book = book;
        this.barcode = barcode;
        this.status = status;
    }

    public BookCopy() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BookCopyStatus getStatus() {
        return status;
    }

    public void setStatus(BookCopyStatus status) {
        this.status = status;
    }
}
