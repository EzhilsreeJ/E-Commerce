package com.example.demo.Model;
import jakarta.persistence.*;


import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "order_tracking")
public class OrderTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderGroupId;
    private String status;
    private String description;
    private String location;
    private String updatedBy;
    private LocalDateTime orderDate;
    private LocalDateTime updateDate;
}
