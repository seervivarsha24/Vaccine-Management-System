package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments,Integer> {
}
