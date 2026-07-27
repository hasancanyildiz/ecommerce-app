package com.ecommerce.ecommerce_app.repository;

import com.ecommerce.ecommerce_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}