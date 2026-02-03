package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.OrdersRepository;
import com.example.demo.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final OrdersRepository ordersRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository, CartRepository cartRepository, OrdersRepository ordersRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.ordersRepository = ordersRepository;
    }

    // CREATE
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // READ BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // UPDATE
    public Product updateProduct(Long id, Product product) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setBrand(product.getBrand());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStockQuantity(product.getStockQuantity());
        existing.setSku(product.getSku());
        existing.setIsActive(product.getIsActive());
        existing.setCategory(product.getCategory());

        return productRepository.save(existing);
    }


    // DELETE
    @Transactional
    public void deleteProduct(Long id) {
        ordersRepository.deleteByUsers_Id(id);
        cartRepository.deleteByProduct_Id(id); // FIRST delete cart rows
        productRepository.deleteById(id);      // THEN delete product
    }
}
