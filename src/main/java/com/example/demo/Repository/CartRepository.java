package com.example.demo.Repository;

import com.example.demo.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    void deleteByUsers_Id(Long userId);
    void deleteByProduct_Id(Long productId);
    Optional<Cart> findByUsers_IdAndProduct_Id(Long userId, Long productId);
}
