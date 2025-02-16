package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        String response=userService.saveUser(user);
        return response;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable int id){
        User user=userService.getUser(id);
        return user;
    }

    @GetMapping("findAll")
    public List<User> findAll(){
        List<User>userList=userService.getAllUser();
        return userList;
    }
}
