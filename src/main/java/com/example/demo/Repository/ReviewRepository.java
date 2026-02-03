package com.example.demo.Repository;

import com.example.demo.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    void deleteByOrder_Users_Id(Long userId);
<<<<<<< HEAD
    Optional<Review> findByUsers_IdAndProduct_Id(Long userId, Long productId);

=======
>>>>>>> 1957c4b6ff9e5403bcb8d45ec6c576c1065d3e5b

}
