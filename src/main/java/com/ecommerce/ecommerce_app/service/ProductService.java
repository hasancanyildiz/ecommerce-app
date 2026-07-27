package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.Product;
import com.ecommerce.ecommerce_app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
       return productRepository.findAll();
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);

    }
    public Product  addProduct(Product product){
       return productRepository.save(product);
    }
    public Product  updateProduct(Long id, Product product){
        Optional<Product> product1=productRepository.findById(id);
        if (product1.isEmpty()){
            return null;
        }
        Product originalProduct =product1.get();
        originalProduct.setName(product.getName());
        originalProduct.setDescription(product.getDescription());
        originalProduct.setPrice(product.getPrice());
        originalProduct.setStockQuantity(product.getStockQuantity());
        return productRepository.save(originalProduct);


    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
