package com.example.bookStore.controller;


import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.User;
import com.example.bookStore.model.repo.AccountRepo;
import com.example.bookStore.service.AccountService;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class CustomerController {
    @Autowired
    private UserService userService;


    @GetMapping("/allCustomers")
    public String showAllCustomersPage(Model model){
        List<User> users= userService.getAllCustomers();
        model.addAttribute("users",users);
        return "Admin_view/all-staff";
    }

}
