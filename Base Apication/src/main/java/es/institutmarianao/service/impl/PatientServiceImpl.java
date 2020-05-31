package es.institutmarianao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.service.PatientService;
import es.institutmarianao.serviceweb.PatientWebService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientWebService patientWebService;

	@Override
	public void addPatient(Patient patient) {
		patientWebService.add(patient);

	}

	@Override
	public Patient getUserByDni(String name) {
		return patientWebService.getUserByDni(name);
	}

}
