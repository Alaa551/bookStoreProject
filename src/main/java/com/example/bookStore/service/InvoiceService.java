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

    public int enquiryOfAllInvoices(){
        int totalPrice=0;
        for (Invoice invoice: getAllInvoices()){
            int orderPrice= invoice.getOrder().getTotalPrice();
            int shipmentPrice=invoice.getOrder().getShipment().getPrice();

            totalPrice+=(shipmentPrice+orderPrice);
        }
        return totalPrice;
    }

}
