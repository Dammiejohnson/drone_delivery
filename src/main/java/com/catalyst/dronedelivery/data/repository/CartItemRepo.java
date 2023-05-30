package com.catalyst.dronedelivery.data.repository;

import com.catalyst.dronedelivery.data.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}
