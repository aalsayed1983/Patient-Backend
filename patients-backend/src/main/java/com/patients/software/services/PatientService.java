package com.patients.software.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patients.software.domain.Patient;
import com.patients.software.model.PatientCreateModel;
import com.patients.software.model.PatientModel;
import com.patients.software.repository.PatientRepo;

/**
 * AttributeService
 */

@Service
public class PatientService {

	private final PatientRepo patientRepo;

	@Autowired
	public PatientService(PatientRepo attributeRepo) {
		this.patientRepo = attributeRepo;
	}
	
	@Transactional
	public List<PatientModel> listAll() {
		return patientRepo.findAll().stream().map(this::mapToPatientModel).collect(Collectors.toList());
	}
	
	@Transactional
	public PatientModel getById(Long Id) {
		return patientRepo.findById(Id).map(this::mapToPatientModel).orElse(null);
	}
	
	@Transactional
	public PatientModel addNewPatient(PatientCreateModel patientCreateModel) {
		Patient patient = patientRepo.save(mapToPatient(patientCreateModel, null));
		return mapToPatientModel(patient);
	}
	
	@Transactional
	public void updatePatient(PatientCreateModel patientCreateModel, Long id) {
		patientRepo.findById(id)
				.ifPresent(patientToUpdate -> patientRepo.save(mapToPatient(patientCreateModel, patientToUpdate)));
	}
	
	@Transactional
	public void deletePatient(Long id) {
		patientRepo.findById(id).ifPresent(patientToDelete -> patientRepo.delete(patientToDelete));
	}
	
	private PatientModel mapToPatientModel(Patient patient) {
		PatientModel patientModel = new PatientModel();
		
		patientModel.setId(patient.getId());
		patientModel.setDateOfBirth(patient.getDateOfBirth());
		patientModel.setForenames(patient.getForenames());
		patientModel.setHomeTelephoneNumber(patient.getHomeTelephoneNumber());
		patientModel.setPasNumber(patient.getPasNumber());
		patientModel.setSexCode(patient.getSexCode());
		patientModel.setSurname(patient.getSurname());
		
		return patientModel;
	}
	
	private Patient mapToPatient(PatientCreateModel patientCreateModel, Patient fromPatient) {
		Patient patient = fromPatient;
		
		if(fromPatient == null) {
			patient = new Patient();
		}
		patient.setDateOfBirth(patientCreateModel.getDateOfBirth());
		patient.setForenames(patientCreateModel.getForenames());
		patient.setHomeTelephoneNumber(patientCreateModel.getHomeTelephoneNumber());
		patient.setPasNumber(patientCreateModel.getPasNumber());
		patient.setSexCode(patientCreateModel.getSexCode());
		patient.setSurname(patientCreateModel.getSurname());
		
		return patient;
	}
}
