package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AssociateRequestDTO;
import com.example.vaccineManagementSystem.Exceptions.CenterNotFound;
import com.example.vaccineManagementSystem.Exceptions.DoctorAlreadyExits;
import com.example.vaccineManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.Exceptions.EmailIdEmpty;
import com.example.vaccineManagementSystem.Model.Doctor;
import com.example.vaccineManagementSystem.Model.VaccineCenter;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccineRepository vaccineRepository;
    public String addDoctor(Doctor doctor) throws EmailIdEmpty, DoctorAlreadyExits {
        if(doctor.getEmailId()==null){
            throw new EmailIdEmpty("Email Id is mandatory");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExits("Doctor exits..");
        }
        doctorRepository.save(doctor);
        return "Doctor added";
    }

    public String associateCenter(AssociateRequestDTO associateRequestDTO) throws DoctorNotFound, CenterNotFound {
        Integer docId=associateRequestDTO.getDocId();
        if(!doctorRepository.findById(docId).isPresent())
            throw new DoctorNotFound("Doctor not found");
        Integer centerId=associateRequestDTO.getCenterId();
        if(!vaccineRepository.findById(centerId).isPresent())
            throw new CenterNotFound("Center Not Found");
        Doctor doctor=doctorRepository.findById(docId).get();
        VaccineCenter vaccineCenter=vaccineRepository.findById(centerId).get();
        doctor.setVaccineCenter(vaccineCenter);
        vaccineCenter.getDr().add(doctor);
        vaccineRepository.save(vaccineCenter);//using cascading doctor variables are shaved too
        return "doctor associated";
    }
}
