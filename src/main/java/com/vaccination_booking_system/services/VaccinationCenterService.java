package com.vaccination_booking_system.services;

import com.vaccination_booking_system.exceptions.VaccinationAddressNotFound;
import com.vaccination_booking_system.model.VaccinationCenter;
import com.vaccination_booking_system.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public String addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {
        if(vaccinationCenter.getAddress()==null){
            throw new VaccinationAddressNotFound("Vaccination address is not found or it is empty");
        }
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Vaccination center added at a location "+ vaccinationCenter.getAddress();
    }
}
