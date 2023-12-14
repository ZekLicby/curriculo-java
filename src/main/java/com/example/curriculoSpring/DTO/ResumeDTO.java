package com.example.curriculoSpring.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ResumeDTO {

    private Long id;

    private String fullName;

    private Integer ageYears;

    private String emailAddress;

    private Integer phoneNumber;

    private String currentOccupation;

    private Integer experienceYears;
}
