package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.exceptions.UserNotFoundException;
import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.requestDto.UpdateEmailDto;
import com.vaccination_booking_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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


    @GetMapping("/getVaccinationDate")
    public Date vaccinationDate(@RequestParam("userId") Integer userId){
        return userService.getVacccDate(userId);
    }

    @PutMapping("/update")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/findByEmail/{email}")
    private User findByEmail(@PathVariable("email") String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

}
