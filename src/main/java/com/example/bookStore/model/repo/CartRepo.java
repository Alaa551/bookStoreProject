package com.example.bookStore.model.repo;

import com.example.bookStore.model.entities.Cart;
import com.example.bookStore.model.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Integer> {
}
