package com.example.librarymenago.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private BookCopy bookCopy;
    private Date startDate;
    private Date endDate;

    public Rent() {
    }

    public Rent(User user, BookCopy bookCopy, Date startDate, Date endDate) {
        this.user = user;
        this.bookCopy = bookCopy;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookCopy getBook() {
        return bookCopy;
    }

    public void setBook(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
