package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Product;
import com.example.demo.Model.Users;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Service.CartService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    // Constructor injection
    public CartController(CartService cartService,
                          UsersRepository usersRepository,
                          ProductRepository productRepository,
                          CartRepository cartRepository) {
        this.cartService = cartService;
        this.usersRepository = usersRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    // CREATE
    @PostMapping("/add")
    public Cart addCartItem(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    // READ ALL
    @GetMapping
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Cart updateCartItem(@PathVariable Long id, @RequestBody Cart cart) {
        cart.setId(id);
        return cartService.updateCart(cart);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "Cart Item Deleted Successfully!";
    }
}
