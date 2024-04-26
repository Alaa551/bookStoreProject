package com.example.bookStore.controller;


import com.example.bookStore.model.entities.Account;
import com.example.bookStore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bookStore")
public class AuthController {
    @Autowired
    private AccountService userService;

    @GetMapping("/start")
    public String showLoginPage(Model model){
        model.addAttribute("account",new Account());
        return "Admin_view/login";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute Account account,Model model) {
        if(userService.login(account)){
            return "redirect:/bookStore/showDashboard";
        }
        model.addAttribute("error",true);
        return "Admin_view/login";

    }




}
