package com.vaccination_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaccination_booking_system.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(nullable = false,unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList=new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private VaccinationCenter vaccinationCenter;
}
