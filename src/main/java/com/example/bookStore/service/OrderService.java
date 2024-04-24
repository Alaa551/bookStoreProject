package com.example.bookStore.service;


import com.example.bookStore.model.entities.Order;
import com.example.bookStore.model.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders(){
      return orderRepo.findAll();
    }
}
