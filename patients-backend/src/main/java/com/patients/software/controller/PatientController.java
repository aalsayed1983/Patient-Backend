package com.patients.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patients.software.model.PatientCreateModel;
import com.patients.software.model.PatientModel;
import com.patients.software.services.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	@Autowired PatientService patientService;
	
	/** GET all patients */
	@GetMapping
	public List<PatientModel> get() {
		return patientService.listAll();
	}
	
	/** GET patient by Id*/
	@GetMapping(value = "/{id}")
	public PatientModel getById(@PathVariable Long id) {
		return patientService.getById(id);
	}
	
	/** Add New patient */
	@PostMapping
	public PatientModel addNewPatient(@RequestBody PatientCreateModel patientCreateModel) {
		return patientService.addNewPatient(patientCreateModel);
	}
	
	/** Update patient */
	@PutMapping(value = "/{id}")
	public void updatePatient(@RequestBody PatientCreateModel patientCreateModel, @PathVariable Long id) {
		patientService.updatePatient(patientCreateModel, id);
	}
	
	/** delete patient by Id */
	@DeleteMapping(value = "/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}
}
