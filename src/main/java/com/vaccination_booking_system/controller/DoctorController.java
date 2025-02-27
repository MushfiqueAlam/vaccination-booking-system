package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.exceptions.DoctorNotFoundException;
import com.vaccination_booking_system.model.Doctor;
import com.vaccination_booking_system.requestDto.AssociateDoctorDto;
import com.vaccination_booking_system.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity saveDoctor(@RequestBody Doctor doctor){
        try {
            String response = doctorService.addDoctor(doctor);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/associate")
    public ResponseEntity associateDoctor(@RequestBody AssociateDoctorDto associateDoctorDto){
        try{
            String response=doctorService.associateDoctor(associateDoctorDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getDoctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable Integer id){
        try{
            Doctor doctor=doctorService.getDoctor(id);
            return new ResponseEntity<>(doctor,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
