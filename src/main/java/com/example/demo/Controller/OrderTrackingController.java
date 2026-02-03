package com.example.demo.Controller;

import com.example.demo.Model.OrderTracking;
import com.example.demo.Service.OrderTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-tracking")
public class OrderTrackingController {

    private final OrderTrackingService orderTrackingService;

    public OrderTrackingController(OrderTrackingService orderTrackingService) {
        this.orderTrackingService = orderTrackingService;
    }

    // CREATE
    @PostMapping
    public OrderTracking addTracking(@RequestBody OrderTracking orderTracking) {
        return orderTrackingService.save(orderTracking);
    }

    // READ ALL
    @GetMapping
    public List<OrderTracking> getAllTracking() {
        return orderTrackingService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public OrderTracking getTrackingById(@PathVariable Long id) {
        return orderTrackingService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public OrderTracking updateTracking(@PathVariable Long id,
                                        @RequestBody OrderTracking orderTracking) {
        //orderTracking.setId(id);
        return orderTrackingService.update(id,orderTracking);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTracking(@PathVariable Long id) {
        orderTrackingService.delete(id);
        return "Order tracking deleted successfully";
    }
}
