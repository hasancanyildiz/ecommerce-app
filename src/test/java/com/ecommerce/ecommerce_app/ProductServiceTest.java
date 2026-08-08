package com.ecommerce.ecommerce_app;


import com.ecommerce.ecommerce_app.model.Product;
import com.ecommerce.ecommerce_app.repository.ProductRepository;
import com.ecommerce.ecommerce_app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;
    @Test
    void shouldReturnProductWhenIdExists() {
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Laptop");
        mockProduct.setPrice(new BigDecimal("25000.00"));
        mockProduct.setStockQuantity(10);

        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));

        Product result = productService.getProductById(1L);

        assertEquals("Laptop", result.getName());
    }

    @Test
    void shouldReturnNullWhenProductNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        Product result = productService.getProductById(99L);

        assertNull(result);
    }
    @Test
    void shouldCountInSockProducts() {
        Product product1=new Product();
        product1.setStockQuantity(5);
        Product product2=new Product();
        product2.setStockQuantity(0);
        Product product3=new Product();
        product3.setStockQuantity(3);
        List<Product> allProducts = List.of(product1, product2, product3);
        when(productRepository.findAll()).thenReturn(allProducts);
        int result = productService.countInStockProducts();

        assertEquals(2, result);
        System.out.println(result);
    }


}
