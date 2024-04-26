package com.example.bookStore.controller;


import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.Category;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/deleteCustomer/{id}")
    private String deleteBook(@PathVariable int id){
        userService.deleteCustomer(id);
        return "redirect:/bookStore/allCustomers";
    }

    @GetMapping("/editCustomerPage/{id}")
    private String showUpdateBookPage(Model model, @PathVariable int id) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user.get());
        return "Admin_view/edit-customer";
    }

    @GetMapping("/editCustomer/{id}")
    private String updateBook(@ModelAttribute("user") User user,@PathVariable int id) {
        User oldUserData = userService.getUser(id).get();
       user.setId(id);
       user.setAddress(oldUserData.getAddress());
       user.setAccount(oldUserData.getAccount());
       userService.saveUser(user);
        return "redirect:/bookStore/allCustomers";
    }


}
