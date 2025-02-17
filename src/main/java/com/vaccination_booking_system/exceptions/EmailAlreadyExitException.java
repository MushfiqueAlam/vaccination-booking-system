package com.vaccination_booking_system.exceptions;

public class EmailAlreadyExitException extends Exception{
    public EmailAlreadyExitException(String message){
        super(message);
    }
}
