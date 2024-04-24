package com.example.bookStore.service;

import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.Order;
import com.example.bookStore.model.repo.BookRepo;
import com.example.bookStore.model.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks(){
        List<Book> books=bookRepo.findAll();
        for (Book book:books){
            book.setBookType(getCategoryName(book.getId()));
        }
        return books;
    }

    private String getCategoryName(int bookId){
        return bookRepo.findCategoryNameByBookId(bookId);
    }


}

