package com.example.demo.Repository;

import com.example.demo.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    void deleteByOrder_Users_Id(Long userId);

}
