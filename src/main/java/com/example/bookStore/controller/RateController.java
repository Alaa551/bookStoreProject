package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.entities.Rate;
import com.example.bookStore.service.OfferService;
import com.example.bookStore.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class RateController {
    @Autowired
    private RateService rateService;


    @GetMapping("/rates")
    public String showRatesPage(Model model) {
        List<Rate> rates = rateService.getAllRates();
        model.addAttribute("rates", rates);
        return "Admin_view/Rate";
    }

}