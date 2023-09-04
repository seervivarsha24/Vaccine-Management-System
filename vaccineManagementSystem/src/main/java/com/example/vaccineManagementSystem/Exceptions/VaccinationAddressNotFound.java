package com.example.vaccineManagementSystem.Exceptions;

import com.example.vaccineManagementSystem.Model.VaccineCenter;

public class VaccinationAddressNotFound extends Exception{
    public VaccinationAddressNotFound(String message){
        super(message);
    }
}
