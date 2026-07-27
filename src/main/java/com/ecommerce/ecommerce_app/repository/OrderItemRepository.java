package com.ecommerce.ecommerce_app.repository;

import com.ecommerce.ecommerce_app.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}