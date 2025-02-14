package com.vaccination_booking_system.model;

import com.vaccination_booking_system.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

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
}
