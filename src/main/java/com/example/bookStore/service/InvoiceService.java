package com.example.bookStore.service;


import com.example.bookStore.model.entities.Invoice;
import com.example.bookStore.model.repo.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public List<Invoice> getAllInvoices(){
        return invoiceRepo.findAll();
    }

}
