package com.example.demo.Model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isActive;
    private String description;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    private LocalDateTime createdAt;

}
