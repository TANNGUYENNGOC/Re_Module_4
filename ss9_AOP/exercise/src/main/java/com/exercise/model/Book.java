package com.exercise.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String nameBook;

    private int amount;
    private int availableBooks;
    private int borrowedBooks;

    public Book() {
    }

    public Book(int id, String nameBook, int amount, int availableBooks, int borrowedBooks) {
        this.id = id;
        this.nameBook = nameBook;
        this.amount = amount;
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
    }

    public Book(String nameBook, int amount, int availableBooks, int borrowedBooks) {
        this.nameBook = nameBook;
        this.amount = amount;
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int sachHienCo) {
        this.availableBooks = sachHienCo;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(int sachDaMuon) {
        this.borrowedBooks = sachDaMuon;
    }
}
