package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AppRequestDto;
import com.example.vaccineManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.Exceptions.UserNotFound;
import com.example.vaccineManagementSystem.Model.Appointments;
import com.example.vaccineManagementSystem.Model.Doctor;
import com.example.vaccineManagementSystem.Model.User;
import com.example.vaccineManagementSystem.Repository.AppointmentRepository;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;

    public String bookApp(AppRequestDto appRequestDto) throws DoctorNotFound, UserNotFound {
        Optional<Doctor> doctorOptional= doctorRepository.findById(appRequestDto.getDocId());
        if(!doctorOptional.isPresent())
            throw new DoctorNotFound("Doctor not found");
        Optional<User> userOptional=userRepository.findById(appRequestDto.getUserId());
        if(!userOptional.isPresent())
            throw new UserNotFound("User is not present");
        Doctor doctor=doctorOptional.get();
        User user=userOptional.get();

        Appointments appointments=new Appointments();
        //Creating the object and setting of its attributes
        appointments.setAppDate(appRequestDto.getAppDate());
        appointments.setAppTime(appRequestDto.getAppTime());
        //setting foreign keys attributes
        appointments.setDoctor(doctor);
        appointments.setUser(user);


    }
}
