package com.vaccination_booking_system.services;

import com.vaccination_booking_system.exceptions.UserNotFoundException;
import com.vaccination_booking_system.model.Dose;
import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.repository.UserRepository;
import com.vaccination_booking_system.requestDto.UpdateEmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Date getVacccDate(Integer userId){

        User user=userRepository.findById(userId).get();
        Dose dose=user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto){
        Integer userId= updateEmailDto.getUserId();
        User user=userRepository.findById(userId).get();
        user.setEmailId(updateEmailDto.getNewEmail());
        userRepository.save(user);
        return "email has been modified with this email id "+updateEmailDto.getNewEmail();
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        User user =userRepository.getByEmailId(email);
        if(user==null){
            throw new UserNotFoundException("User not available with this email id "+email);
        }
        return user;
    }
}
