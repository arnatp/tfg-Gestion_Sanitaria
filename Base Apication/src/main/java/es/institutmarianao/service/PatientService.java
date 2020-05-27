package es.institutmarianao.service;

import es.institutmarianao.domain.Patient;

public interface PatientService {

	void addPatient(Patient newPatientToAdd);

	Patient getUserByDni(String username);

}
