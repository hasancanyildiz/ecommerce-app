package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class Order {
    @Id
    @GeneratedValue
    private long  id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private BigDecimal totalPrice;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
