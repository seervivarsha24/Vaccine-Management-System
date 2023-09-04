package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Model.VaccineCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineCenter,Integer> {
}
