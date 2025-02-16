package com.vaccination_booking_system.services;

import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //save user

    public String saveUser(User user){
        userRepository.save(user);
        return "User added successfully";
    }

    public User getUser(int id){
        Optional<User> user=userRepository.findById(id);
        return user.get();
    }

    public List<User> getAllUser(){
        List<User>userList=userRepository.findAll();
        return userList;
    }
}
