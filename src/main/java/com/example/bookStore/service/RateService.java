package com.example.bookStore.service;


import com.example.bookStore.model.entities.Offer;
import com.example.bookStore.model.entities.Rate;
import com.example.bookStore.model.repo.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    @Autowired
    private RateRepo rateRepo;

    public List<Rate> getAllRates(){
        return rateRepo.findAll();
    }

}
