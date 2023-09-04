package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Model.VaccineCenter;
import com.example.vaccineManagementSystem.Service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.html.HTMLTableCellElement;

@RestController
@RequestMapping("/vaccineCenter")
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @PostMapping("/add")
    public ResponseEntity<String> addCenter(@RequestBody VaccineCenter vaccineCenter){
        try{
            String r=vaccineService.addCenter(vaccineCenter);
            return new ResponseEntity<>(r,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
