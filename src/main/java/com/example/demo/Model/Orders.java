package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderGroupId;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private int quantity;
    private BigDecimal price;
    private String orderStatus;
    private Boolean isReviewed;
    private LocalDateTime created_at;


}
