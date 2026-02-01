package com.example.demo.Service;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public Users save(Users users){
        return usersRepository.save(users);
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    public Users getUserById(Long id){
        return usersRepository.findById(Math.toIntExact(id)).orElseThrow(()-> new RuntimeException("User not found with id: " + id));
    }
    public void deleteUserById(Long id){
        usersRepository.deleteById(Math.toIntExact(id));
    }
    public Users updateUser(Users users){
        Users existingUser = usersRepository.findById(Math.toIntExact(users.getId()))
                .orElseThrow(() -> new RuntimeException("User not found with id: " + users.getId()));

        existingUser.setName(users.getName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());

        return usersRepository.save(existingUser);
    }


}
