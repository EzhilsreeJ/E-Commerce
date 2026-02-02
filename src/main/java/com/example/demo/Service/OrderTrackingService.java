package com.example.demo.Service;

import com.example.demo.Model.OrderTracking;
import com.example.demo.Repository.OrderTrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTrackingService {

    private final OrderTrackingRepository orderTrackingRepository;

    public OrderTrackingService(OrderTrackingRepository orderTrackingRepository) {
        this.orderTrackingRepository = orderTrackingRepository;
    }

    // CREATE
    public OrderTracking save(OrderTracking orderTracking) {
        return orderTrackingRepository.save(orderTracking);
    }

    // READ ALL
    public List<OrderTracking> getAll() {
        return orderTrackingRepository.findAll();
    }

    // READ BY ID
    public OrderTracking getById(Long id) {
        return orderTrackingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderTracking not found with id: " + id));
    }

    // UPDATE
    public OrderTracking update(Long id, OrderTracking orderTracking) {

        OrderTracking existing = orderTrackingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("OrderTracking not found with id: " + id)
                );

        existing.setOrderGroupId(orderTracking.getOrderGroupId());
        existing.setStatus(orderTracking.getStatus());
        existing.setDescription(orderTracking.getDescription());
        existing.setLocation(orderTracking.getLocation());
        existing.setUpdatedBy(orderTracking.getUpdatedBy());
        existing.setOrderDate(orderTracking.getOrderDate());
        existing.setUpdateDate(orderTracking.getUpdateDate());

        return orderTrackingRepository.save(existing);
    }


    // DELETE
    public void delete(Long id) {
        orderTrackingRepository.deleteById(id);
    }
}
