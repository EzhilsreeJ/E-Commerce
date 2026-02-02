package com.example.demo.Controller;

import com.example.demo.Model.Users;
import com.example.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @PostMapping("/add")
    public Users addUser(@RequestBody Users users){
        return usersService.save(users);
    }
    @GetMapping("/")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id){
        return usersService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        usersService.deleteUserById(id);
        return ResponseEntity.ok("User Deleted Successfully!");
    }
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users users){
        users.setId(id);
        return usersService.updateUser(users);
    }

}