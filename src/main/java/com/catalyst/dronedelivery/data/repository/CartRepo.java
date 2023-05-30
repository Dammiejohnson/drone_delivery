package com.catalyst.dronedelivery.data.repository;

import com.catalyst.dronedelivery.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo  extends JpaRepository<Cart, Long> {
}
