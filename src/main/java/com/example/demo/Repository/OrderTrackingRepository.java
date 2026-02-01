package com.example.demo.Repository;

import com.example.demo.Model.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking,Long> {
}
