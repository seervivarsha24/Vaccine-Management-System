package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Model.User;
import com.example.vaccineManagementSystem.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("/giveDose")
    public String giveDose(@RequestParam("doseId") String doseId,@RequestParam("userId") Integer userID){
        return doseService.giveDose(doseId,userID);
    }


}
