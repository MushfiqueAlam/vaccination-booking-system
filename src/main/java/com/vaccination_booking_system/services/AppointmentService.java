package com.vaccination_booking_system.services;

import com.vaccination_booking_system.enums.Gender;
import com.vaccination_booking_system.exceptions.DoctorNotFoundException;
import com.vaccination_booking_system.exceptions.UserNotFoundException;
import com.vaccination_booking_system.model.Appointment;
import com.vaccination_booking_system.model.Doctor;
import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.repository.AppointmentRepository;
import com.vaccination_booking_system.repository.DoctorRepository;
import com.vaccination_booking_system.repository.UserRepository;
import com.vaccination_booking_system.requestDto.AppointmentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String bookAppointment(AppointmentRequestDto appointmentRequestDto) throws DoctorNotFoundException, UserNotFoundException {
        Doctor doctor=doctorRepository.findById(appointmentRequestDto.getDoctorId()).get();
        if(doctor==null){
            throw new DoctorNotFoundException("Doctor is not available with this id");
        }

        User user=userRepository.findById(appointmentRequestDto.getUserId()).get();
        if(user==null){
            throw new UserNotFoundException("User not found");
        }

        Appointment appointment=new Appointment();
        appointment.setAppointmentDate(appointmentRequestDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequestDto.getAppointmentTime());
        appointment.setDoctor(doctor);
        appointment.setUser(user);


        appointment=appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        //send email to the user

        String body="Hi!"+user.getName()+"\n"+ "You have successfully booked an appointment on "+appointment.getAppointmentDate()+"at"+
                appointment.getAppointmentTime()+"\n"+"Your doctor is "+doctor.getName()+"\n"+
                "please reach at "+doctor.getVaccinationCenter().getAddress()+"\n"+"Mask is mandatory";

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("mushfique1213@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setSubject("Appointment Confirmed");
        mailMessage.setText(body);
        javaMailSender.send(mailMessage);
        String enteredString="";

        if(enteredString.equals(Gender.FEMALE)|| enteredString.equals(Gender.MALE)){
            return "Appointment booked successfully";
        }


        return "Appointment is successfully given";
    }
}
