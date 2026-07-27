package com.ecommerce.ecommerce_app.repository;

import com.ecommerce.ecommerce_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // No methods are needed here—common CRUD operations like
    // findAll(), save(), and deleteById() are provided automatically.
}