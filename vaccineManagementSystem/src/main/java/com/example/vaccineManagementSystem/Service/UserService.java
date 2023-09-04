package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Dtos.RequestDtos.UpdateEmailDto;
import com.example.vaccineManagementSystem.Model.Dose;
import com.example.vaccineManagementSystem.Model.User;
import com.example.vaccineManagementSystem.Repository.DoseRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user) {
        user=userRepository.save(user);
        return user;
    }

    public Date getDate(Integer userId) {
        User user=userRepository.findById(userId).get();

        Dose dose=user.getDose();

        return dose.getCreationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId=updateEmailDto.getUserId();
        User user=userRepository.findById(userId).get();
        user.setEmailId(updateEmailDto.getNewEmail());
        userRepository.save(user);
        return "Email updated";
    }

    public User getByEmail(String email) {
        User user=userRepository.findByEmailId(email);
        return user;
    }
}
