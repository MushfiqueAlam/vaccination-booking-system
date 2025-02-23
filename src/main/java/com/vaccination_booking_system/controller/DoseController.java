package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.model.Dose;
import com.vaccination_booking_system.services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
    @PostMapping("/giveDose")
    public String giveDose(@RequestBody Dose dose){

        return doseService.giveDose(dose);
    }
}
