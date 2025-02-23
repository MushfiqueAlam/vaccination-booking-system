package com.vaccination_booking_system.requestDto;

import lombok.Data;

@Data
public class UpdateEmailDto {
    private int userId;
    private String newEmail;
}
