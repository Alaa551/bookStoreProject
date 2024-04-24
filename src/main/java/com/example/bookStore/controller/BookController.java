package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.Order;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("bookStore")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String showOrdersPage(Model model){
        List<Book> books= bookService.getAllBooks();
        model.addAttribute("books",books);
        return "Admin_view/all-Books";
    }
}
