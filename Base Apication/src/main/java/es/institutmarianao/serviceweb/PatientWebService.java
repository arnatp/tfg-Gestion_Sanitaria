package es.institutmarianao.serviceweb;

import java.util.List;

import es.institutmarianao.domain.Patient;

public interface PatientWebService {

	List<Patient> getAll();

	void add(Patient patient);

	void update(Patient patient);

	void delete(Patient patient);

	Patient getUserByDni(String dni);

	Patient getUserByMediCard(String mediCard);

}
