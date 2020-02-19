package com.patients.software.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PatientCreateModel
 */
@Data
@NoArgsConstructor

public class PatientCreateModel {
    private String pasNumber;
    private String forenames;
    private String surname;
    private String sexCode;
    private String homeTelephoneNumber;
    private Date dateOfBirth;
}
