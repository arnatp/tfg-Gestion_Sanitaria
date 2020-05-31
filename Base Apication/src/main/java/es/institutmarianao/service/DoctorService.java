package es.institutmarianao.service;

import java.util.List;

import es.institutmarianao.domain.Doctor;

public interface DoctorService {

	List<Doctor> getAll();

	void add(Doctor doctor);

	void update(Doctor doctor);

	void delete(Doctor doctor);

	Doctor getUserByDni(String dni);

	Doctor getUserByMediCard(String mediCard);

}
