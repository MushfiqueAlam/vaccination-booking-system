package com.vaccination_booking_system.repository;

import com.vaccination_booking_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    public Doctor findByEmail(String email);
}
