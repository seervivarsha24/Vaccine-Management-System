package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.AppRequestDto;
import com.example.vaccineManagementSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookApp(@RequestBody AppRequestDto appRequestDto){
        return appointmentService.bookApp(appRequestDto);
    }
}
