package com.example.bookStore.controller;

import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.entities.User;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.OfferService;
import com.example.bookStore.service.OrderService;
import com.example.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @Autowired
    private BookService bookService;

    @GetMapping("/offers")
    public String showOffersPage(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("offers", offers);
        return "Admin_view/Offers";
    }

    @GetMapping("/deleteOffer/{id}")
    private String deleteOffer(@PathVariable int id) {
        offerService.deleteOffer(id);
        return "redirect:/bookStore/offers";
    }

    @GetMapping("/showAddOfferPage")
    private String showAddOfferPage(Model model) {
        model.addAttribute("offer", new Offer());
        return "Admin_view/add-offer";
    }

    @GetMapping("/addOffer")
    private String addOffer(@ModelAttribute("offer") Offer offer, Model model) {
        if (bookService.isBookFound(offer.getBook().getId())) {
            offerService.saveOffer(offer);
            return "redirect:/bookStore/offers";

        }

        model.addAttribute("error", true);
        return "Admin_view/add-offer";

    }


    // edit

    @GetMapping("/showEditOfferPage/{id}")
    private String showEditOfferPage(Model model,@PathVariable int id) {
        Offer offer= offerService.getOffer(id).get();
        model.addAttribute("offer", offer);
        return "Admin_view/edit-offer";
    }

    @GetMapping("/editOffer")
    private String editOffer(@ModelAttribute("offer") Offer offer) {

        offerService.saveOffer(offer);
        return "redirect:/bookStore/offers";

    }

}

