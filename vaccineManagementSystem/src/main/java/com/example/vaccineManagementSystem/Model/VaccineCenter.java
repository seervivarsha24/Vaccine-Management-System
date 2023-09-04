package com.example.vaccineManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vaccination_center")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String centerName;

    private LocalTime openTime;

    private LocalTime closeTime;

    private String address;

    private int doseCapacity;

    @OneToMany(mappedBy = "vaccineCenter",cascade = CascadeType.ALL)
    private List<Doctor> dr=new ArrayList<>();
}
