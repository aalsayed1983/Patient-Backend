package com.patients.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patients.software.domain.Patient;

/**
 * PatientRepo
 */
@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
