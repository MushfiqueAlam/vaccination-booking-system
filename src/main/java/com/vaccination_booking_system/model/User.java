package com.vaccination_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaccination_booking_system.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(nullable = false,unique = true)
    private String emailId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String mobile;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment>appointmentList=new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private Dose dose;
}
