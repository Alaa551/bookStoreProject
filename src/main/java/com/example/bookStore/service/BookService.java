package com.example.bookStore.service;

import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        for (Book book : books) {
            book.setBookType(getCategoryName(book.getId()));
            bookRepo.save(book);
        }
        return books;
    }

    private String getCategoryName(int bookId) {
        return bookRepo.findCategoryNameByBookId(bookId);
    }

    public void deleteBook(int bookId) {
        bookRepo.deleteById(bookId);
    }

    public void saveBook(Book book) {
        bookRepo.save(book);
    }


    public Optional<Book> getBook(int id) {
        return bookRepo.findById(id);
    }

    public boolean isBookFound(int id) {
        return getBook(id).isPresent();
    }

    public String encodeBookImage(Book book) {
        return Base64.getEncoder().encodeToString(book.getImage());

    }

    public int numOfBooks(){
        return getAllBooks().size();
    }
}

