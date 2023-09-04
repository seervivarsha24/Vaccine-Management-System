package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Model.Dose;
import com.example.vaccineManagementSystem.Model.User;
import com.example.vaccineManagementSystem.Repository.DoseRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    UserRepository userRepository;
    public String giveDose(String doseId, Integer userID) {
        User user=userRepository.findById(userID).get();

        Dose dose=new Dose();

        dose.setDoseId(doseId);
        dose.setUser(user);
        user.setDose(dose);
        userRepository.save(user);
        //Child will automatically get saved because of cascading effect.
        return "Dose given to user";
    }
}
