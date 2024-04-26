package com.example.bookStore.model.repo;

import com.example.bookStore.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
