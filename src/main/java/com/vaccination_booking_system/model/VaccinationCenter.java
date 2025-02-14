package com.vaccination_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "vaccinationCenter",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Doctor>doctorList=new ArrayList<>();
}
