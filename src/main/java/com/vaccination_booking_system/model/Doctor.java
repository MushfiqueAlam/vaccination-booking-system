package com.vaccination_booking_system.model;

import com.vaccination_booking_system.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

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
}
