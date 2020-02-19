package com.patients.software.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PatientModel
 */
@Data
@NoArgsConstructor
public class PatientModel extends PatientCreateModel {
	private Long id;
}
