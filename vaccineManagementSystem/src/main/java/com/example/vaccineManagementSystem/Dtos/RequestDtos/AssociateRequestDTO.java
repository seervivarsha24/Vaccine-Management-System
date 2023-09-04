package com.example.vaccineManagementSystem.Dtos.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociateRequestDTO {
    private Integer docId;
    private Integer centerId;
}
