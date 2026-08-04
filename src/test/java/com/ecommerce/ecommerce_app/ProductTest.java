package com.ecommerce.ecommerce_app;

import com.ecommerce.ecommerce_app.model.Product;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    public void productShouldStoreValuesCorrectly() {
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(new BigDecimal("25000.00"));
        product.setStockQuantity(10);

        assertEquals("Laptop", product.getName());
        assertEquals(new BigDecimal("25000.00"), product.getPrice());
        assertEquals(10, product.getStockQuantity());
    }
}