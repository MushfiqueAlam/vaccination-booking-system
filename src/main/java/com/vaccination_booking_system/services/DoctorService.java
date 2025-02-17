package com.vaccination_booking_system.services;

import com.vaccination_booking_system.exceptions.CenterNotFoundException;
import com.vaccination_booking_system.exceptions.DoctorNotFoundException;
import com.vaccination_booking_system.exceptions.EmailAlreadyExitException;
import com.vaccination_booking_system.exceptions.EmailEmtyException;
import com.vaccination_booking_system.model.Doctor;
import com.vaccination_booking_system.model.VaccinationCenter;
import com.vaccination_booking_system.repository.DoctorRepository;
import com.vaccination_booking_system.repository.VaccinationCenterRepository;
import com.vaccination_booking_system.requestDto.AssociateDoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public String addDoctor(Doctor doctor) throws EmailEmtyException ,EmailAlreadyExitException{
        if(doctor.getEmail()==null){
            throw new EmailEmtyException("Email is empty ao give a valid email id");
        }
        if(doctorRepository.findByEmail(doctor.getEmail())!=null){
            throw new EmailAlreadyExitException("This email is already exits");
        }
        doctorRepository.save(doctor);
        return "Doctor has been added successful into the databases";
    }

    public String associateDoctor(AssociateDoctorDto associateDoctorDto) throws DoctorNotFoundException, CenterNotFoundException {
        int doctorId=associateDoctorDto.getDoctorId();
        Optional<Doctor>doctorOptional=doctorRepository.findById(doctorId);
        if(!doctorOptional.isPresent()){
            throw new DoctorNotFoundException("Doctor is not available with this id"+doctorId);
        }

        int centerId=associateDoctorDto.getCenterId();
        Optional<VaccinationCenter>vaccinationCenterOptional=vaccinationCenterRepository.findById(centerId);
        if(!vaccinationCenterOptional.isPresent()){
            throw new CenterNotFoundException("Center is not available with this center id "+centerId);
        }

        Doctor doctor=doctorOptional.get();
        VaccinationCenter vaccinationCenter=vaccinationCenterOptional.get();

        doctor.setVaccinationCenter(vaccinationCenter);

        vaccinationCenter.getDoctorList().add(doctor);
        vaccinationCenterRepository.save(vaccinationCenter);


        return "Doctor has been associated";
    }

}
