package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.Model.VaccineCenter;
import com.example.vaccineManagementSystem.Repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {
    @Autowired
    VaccineRepository vaccineRepository;

    public String addCenter(VaccineCenter vaccineCenter) throws VaccinationAddressNotFound {
        if(vaccineCenter.getAddress()== null){
            throw new VaccinationAddressNotFound("Vaccination Address Is Empty");
        }
        vaccineRepository.save(vaccineCenter);
        return "Vaccination Center added"+vaccineCenter.getAddress();
    }
}
