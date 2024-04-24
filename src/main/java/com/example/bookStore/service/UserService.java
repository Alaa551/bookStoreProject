package com.example.bookStore.service;


import com.example.bookStore.model.entities.Book;
import com.example.bookStore.model.entities.User;
import com.example.bookStore.model.repo.AccountRepo;
import com.example.bookStore.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountRepo accountRepo;

    public List<User> getAllCustomers(){
        List<User> users=userRepo.findAll();
        for (User user:users){
            user.setEmail(accountRepo.findEmailByAccountId(user.getId()));
        }
        return users;
    }
    public String getCustomerEmail(int accountId){
        return accountRepo.findEmailByAccountId(accountId);
    }



}
