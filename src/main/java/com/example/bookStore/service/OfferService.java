package com.example.bookStore.service;


import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.repo.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepo offerRepo;

    public List<Offer> getAllOffers(){
      return offerRepo.findAll();
    }
}
