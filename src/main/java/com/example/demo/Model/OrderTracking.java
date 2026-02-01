package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
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
    private LocalDateTime orderDate;
    private LocalDateTime updateDate;
}
