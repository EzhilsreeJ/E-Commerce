package com.example.demo.Service;

import com.example.demo.Model.Orders;
import com.example.demo.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    // CREATE
    public Orders placeOrder(Orders order) {
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
