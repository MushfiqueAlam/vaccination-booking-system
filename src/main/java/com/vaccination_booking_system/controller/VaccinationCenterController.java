package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.model.VaccinationCenter;
import com.vaccination_booking_system.services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;


    @PostMapping("/addCenter")
    public String addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        try {
            String response=vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
            return response;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
