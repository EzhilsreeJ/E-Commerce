package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    // Constructor injection
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // CREATE
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // READ ALL
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    // READ BY ID
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id: " + id));
    }

    // UPDATE
    public Cart updateCart(Cart cart) {
        Cart existingCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException("Cart item not found with id: " + cart.getId()));

        existingCart.setUsers(cart.getUsers());
        existingCart.setProduct(cart.getProduct());
        existingCart.setQuantity(cart.getQuantity());
        existingCart.setPriceAtAdded(cart.getPriceAtAdded());

        return cartRepository.save(existingCart);
    }

    // DELETE
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}
