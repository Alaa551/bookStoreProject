package com.example.bookStore.service;


import com.example.bookStore.model.Email;
import com.example.bookStore.model.entities.Account;
import com.example.bookStore.model.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private EmailService emailService;

    public boolean isEmailExists(String email) {
        Optional<Account> account = accountRepo.findByEmail(email);
        return account.isPresent();
    }

    public Optional<Account> isEmailExistsAndgetIt(String email) {
        return accountRepo.findByEmail(email);
    }

    public boolean login(Account account) {
        Optional<Account> account1 = accountRepo.findByEmail(account.getEmail());
        return account1.isPresent() && account.getPassword().equals(account1.get().getPassword());


    }

    public boolean sendEmail(String email) {
        String newPassword = generatePassword(10);
        if (changePassword(email,newPassword)) {
            String messege= "Hello, Your New Password is "+ newPassword;
            emailService.sendEmail(
                    new Email(email, "Reset Password Email", messege)
            );
            return true;
        }
        return false;
    }

    public boolean changePassword(String email,String newPass) {
        Optional<Account> account= accountRepo.findByEmail(email);
        if(account.isPresent()){
            account.get().setPassword(newPass);
            accountRepo.save(account.get());
            return true;
        }
        return false;
    }

    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

        // Loop to append random characters from the character set
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }
}
