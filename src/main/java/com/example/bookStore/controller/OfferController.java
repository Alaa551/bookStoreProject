package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.entities.User;
import com.example.bookStore.service.OfferService;
import com.example.bookStore.service.OrderService;
import com.example.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class OfferController {
    @Autowired
    private OfferService offerService;


    @GetMapping("/offers")
    public String showAllCustomersPage(Model model){
        List<Offer> offers= offerService.getAllOffers();
        model.addAttribute("offers",offers);
        return "Admin_view/Offers";
    }

}

