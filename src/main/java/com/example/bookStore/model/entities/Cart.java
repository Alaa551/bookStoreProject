package com.example.bookStore.model.entities;


import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private int numOfBooks;
    private int totalPrice;

    @ManyToMany
    @JoinTable(
            name = "cart_book",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private ArrayList<Book> books = new ArrayList<>();

    public Cart() {
    }

    public Cart(int numOfBooks, int totalPrice, ArrayList<Book> books) {
        this.numOfBooks = numOfBooks;
        this.totalPrice = totalPrice;
        this.books = books;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
