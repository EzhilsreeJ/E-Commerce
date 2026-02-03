package com.example.demo.Repository;

import com.example.demo.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    void deleteByUsers_Id(Long usersId);
    void deleteByProduct_Id(Long productId);
}
