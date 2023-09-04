package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AssociateRequestDTO;
import com.example.vaccineManagementSystem.Model.Doctor;
import com.example.vaccineManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            return doctorService.addDoctor(doctor);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/associateCenter")
    public ResponseEntity<String> associateCenter(@RequestBody AssociateRequestDTO associateRequestDTO){
        try{
            String result=doctorService.associateCenter(associateRequestDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
