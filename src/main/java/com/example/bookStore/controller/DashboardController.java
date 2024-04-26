package com.example.bookStore.controller;

import com.example.bookStore.service.BookService;
import com.example.bookStore.service.InvoiceService;
import com.example.bookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("bookStore")
public class DashboardController {

    @Autowired
    private BookService bookService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private OrderService orderService;



    @GetMapping("/showDashboard")
    public String showDashboard(Model model){
        int totalNumOfBooks= bookService.numOfBooks();
        int numOfOrders= orderService.numOfOrders();
        int enquiry= invoiceService.enquiryOfAllInvoices();

        model.addAttribute("numOfBooks",totalNumOfBooks);
        model.addAttribute("numOfOrders",numOfOrders);
        model.addAttribute("enquiry",enquiry);

        return "Admin_view/index";
    }

    @GetMapping("/logout")
    public String logout(Model model){

        return "redirect:/bookStore/start";
    }

}
