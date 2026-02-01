package com.example.demo.Controller;

import com.example.demo.Model.Orders;
import com.example.demo.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // CREATE
    @PostMapping("/addorder")
    public Orders placeOrder(@RequestBody Orders order) {
        return ordersService.placeOrder(order);
    }

    // READ ALL
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
        return "Order cancelled successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        order.setId(id);
        return ordersService.updateOrder(order);
    }
}
