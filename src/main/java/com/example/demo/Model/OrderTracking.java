package com.example.demo.Model;
import jakarta.persistence.*;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "order_tracking")
public class OrderTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderGroupId;
    private String status;
    private String description;
    private String location;
    private String updatedBy;

    // Auto set when row is CREATED
    @CreationTimestamp
    @Column(name = "order_date", updatable = false)
    private LocalDateTime orderDate;

    // Auto update on every UPDATE
    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
