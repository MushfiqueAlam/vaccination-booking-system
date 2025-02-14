package com.vaccination_booking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate;

    private LocalDateTime appointmentTime;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;
}
