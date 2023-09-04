package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
