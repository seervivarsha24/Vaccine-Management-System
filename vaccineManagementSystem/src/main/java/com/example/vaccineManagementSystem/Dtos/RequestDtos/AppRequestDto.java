package com.example.vaccineManagementSystem.Dtos.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRequestDto {
    private int docId;
    private int userId;
    private Date appDate;
    private LocalTime appTime;
}
