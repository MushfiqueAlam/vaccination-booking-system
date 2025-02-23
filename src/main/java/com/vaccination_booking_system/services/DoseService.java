package com.vaccination_booking_system.services;

import com.vaccination_booking_system.model.Dose;
import com.vaccination_booking_system.model.User;
import com.vaccination_booking_system.repository.DoseRepository;
import com.vaccination_booking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(Dose dose){
//        User user=userRepository.findById(userId).get();
//
//        Dose dose=new Dose();
//        dose.setDoseId(doseId);
//        dose.setUser(user);

//        user.setDose(dose);
       // doseRepository.save(dose);
//        user.setDose(dose);
        doseRepository.save(dose);

        return "Dose has been given Successfully";
    }
}
