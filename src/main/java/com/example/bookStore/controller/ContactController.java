package com.example.bookStore.controller;

import com.example.bookStore.model.Email;
import com.example.bookStore.model.EmailWrapper;
import com.example.bookStore.model.entities.Contact;
import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.service.AccountService;
import com.example.bookStore.service.ContactService;
import com.example.bookStore.service.EmailService;
import com.example.bookStore.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/contacts")
    public String showAllContactsPage(Model model, Model replyModel) {
        List<Contact> contacts = contactService.getAllContactsAfterSetEmails();
        model.addAttribute("contacts", contacts);
        replyModel.addAttribute("email", new Email());
        return "Admin_view/Contact";
    }

    @GetMapping("/reply/{customerEmail}/{contactId}")
    public String setReply(@ModelAttribute("email") Email email, @PathVariable("customerEmail") String customerEmail, @PathVariable("contactId") int contactId) {
        email.setTo(customerEmail);
        email.setSubject("Reply to your contact message from our bookStore admin");
        emailService.sendEmail(email);
        contactService.deleteContact(contactId);
        return "redirect:/bookStore/contacts";
    }


}
