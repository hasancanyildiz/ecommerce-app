package com.ecommerce.ecommerce_app;

import com.ecommerce.ecommerce_app.model.Product;
import com.ecommerce.ecommerce_app.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldSaveAndRetrieveProduct() {
        Product product = new Product();
        product.setName("Test Laptop");
        product.setDescription("Test description");
        product.setPrice(new BigDecimal("15000.00"));
        product.setStockQuantity(5);

        productRepository.save(product);
        List<Product> allProducts = productRepository.findAll();

        assertEquals(1, allProducts.size());
        assertEquals("Test Laptop", allProducts.get(0).getName());
    }
}