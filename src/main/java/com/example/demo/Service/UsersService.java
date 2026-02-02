package com.example.demo.Service;

import com.example.demo.Model.Users;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.OrdersRepository;
import com.example.demo.Repository.ReviewRepository;
import com.example.demo.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final OrdersRepository ordersRepository;
    private final ReviewRepository reviewRepository;
    public UsersService(ReviewRepository reviewRepository, CartRepository cartRepository, OrdersRepository ordersRepository, ReviewRepository reviewRepository1) {
        this.cartRepository = cartRepository;
        this.ordersRepository = ordersRepository;
        this.reviewRepository = reviewRepository;
    }

    public Users save(Users users){
        return usersRepository.save(users);
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    public Users getUserById(Long id){
        return usersRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id: " + id));
    }
    @Transactional
    public void deleteUserById(Long id){
        reviewRepository.deleteByOrder_Users_Id(id);
        ordersRepository.deleteByUsers_Id(id);
        cartRepository.deleteByUsers_Id(id);
        usersRepository.deleteById(id);
    }
    public Users updateUser(Users users){
        Users existingUser = usersRepository.findById(users.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + users.getId()));

        existingUser.setName(users.getName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());

        return usersRepository.save(existingUser);
    }


}
