package com.example.vaccineManagementSystem.Model;

import com.example.vaccineManagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String name;

    private  int age;

    @Column(unique = true)
    private String emailId;

    private String mobileNo;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Dose dose;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointments> appointmentsList=new ArrayList<>();

    public User() {
    }

    public User(int userId, String name, int age, String emailId, String mobileNo, Gender gender, Dose dose,List<Appointments> appointmentsList) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.dose = dose;
    }

}
