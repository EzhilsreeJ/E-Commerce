package com.example.demo.Service;

import com.example.demo.Model.Orders;
import com.example.demo.Model.Product;
import com.example.demo.Model.Users;
import com.example.demo.Repository.OrdersRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;
    public OrdersService(OrdersRepository ordersRepository,
                         ProductRepository productRepository, UsersRepository usersRepository) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
        this.usersRepository = usersRepository;
    }
    // CREATE
    public Orders placeOrder(Orders order) {

        Users user = usersRepository.findById(order.getUsers().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(order.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        order.setUsers(user);
        order.setProduct(product);

        // SET DEFAULTS (this is what you missed)
        order.setIsReviewed(false);
        order.setOrderGroupId("ORD" + System.currentTimeMillis());

        return ordersRepository.save(order);
    }




    // READ ALL
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // READ BY ID
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    // UPDATE
    public Orders updateOrder(Orders order) {
        Orders existingOrder = ordersRepository.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + order.getId()));

        existingOrder.setOrderGroupId(order.getOrderGroupId());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setIsReviewed(order.getIsReviewed());
        existingOrder.setUsers(order.getUsers());
        existingOrder.setProduct(order.getProduct());

        return ordersRepository.save(existingOrder);
    }

    // DELETE
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
