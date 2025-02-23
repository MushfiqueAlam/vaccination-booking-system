package com.vaccination_booking_system.exceptions;

import com.vaccination_booking_system.model.Doctor;

public class DoseNotGivenException extends  Exception{
    public DoseNotGivenException(String message){
        super(message);
    }
}
