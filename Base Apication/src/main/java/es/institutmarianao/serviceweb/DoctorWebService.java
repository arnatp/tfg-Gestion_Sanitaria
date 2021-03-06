package es.institutmarianao.serviceweb;

import java.util.List;

import es.institutmarianao.domain.Doctor;

public interface DoctorWebService {

	List<Doctor> getAll();

	void add(Doctor doctor);

	void update(Doctor doctor);

	void delete(Doctor doctor);

	Doctor getUserByDni(String dni);

	Doctor getuserByMediCard(String mediCard);

}
