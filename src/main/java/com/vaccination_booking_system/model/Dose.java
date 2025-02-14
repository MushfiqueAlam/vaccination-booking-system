package com.vaccination_booking_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String doseId;

    @CreationTimestamp
    private Date vaccinationDate;

    @OneToOne
    @JoinColumn
    private User user;
}
