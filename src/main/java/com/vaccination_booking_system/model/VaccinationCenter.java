package com.vaccination_booking_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String centerName;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private int doseCapacity;
}
