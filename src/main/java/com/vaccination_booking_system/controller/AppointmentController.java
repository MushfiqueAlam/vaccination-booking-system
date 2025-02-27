package com.vaccination_booking_system.controller;

import com.vaccination_booking_system.requestDto.AppointmentRequestDto;
import com.vaccination_booking_system.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public String getAppoinment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try{
            String response=appointmentService.bookAppointment(appointmentRequestDto);
            return response;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
