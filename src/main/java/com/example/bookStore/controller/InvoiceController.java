package com.example.bookStore.controller;


import com.example.bookStore.model.entities.Invoice;
import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookStore")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public String showInvoicesPage(Model model){
        List<Invoice> invoices= invoiceService.getAllInvoices();
        model.addAttribute("invoices",invoices);
        return "Admin_view/payments";
    }
}
