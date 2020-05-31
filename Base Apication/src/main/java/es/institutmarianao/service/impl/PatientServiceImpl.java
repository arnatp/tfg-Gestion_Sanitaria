package es.institutmarianao.service.impl;

import java.util.List;

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
	public List<Patient> getAll() {
		return patientWebService.getAll();
	}

	@Override
	public void add(Patient patient) {
		patientWebService.add(patient);

	}

	@Override
	public void update(Patient patient) {
		patientWebService.update(patient);

	}

	@Override
	public void delete(Patient patient) {
		patientWebService.delete(patient);

	}

	@Override
	public Patient getUserByDni(String name) {
		return patientWebService.getUserByDni(name);
	}

	@Override
	public Patient getUserByMediCard(String mediCard) {
		return patientWebService.getUserByMediCard(mediCard);
	}

}
