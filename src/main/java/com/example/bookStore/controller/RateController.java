package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.entities.Rate;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.OfferService;
import com.example.bookStore.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("bookStore")
public class RateController {
    @Autowired
    private RateService rateService;

    @Autowired
    private BookService bookService;


    @GetMapping("/rates")
    public String showRatesPage(Model model) {
        List<Rate> rates = rateService.getAllRates();
        List<String> encodedImages = rates.stream()
                .map(rate -> bookService.encodeBookImage(rate.getBook()))
                .collect(Collectors.toList());

        model.addAttribute("rates", rates);
        model.addAttribute("encodedImages", encodedImages);
        return "Admin_view/Rate";
    }

}

//width: 100%;
//        border-top-right-radius: 80px;
//        border-top-left-radius: 80px;