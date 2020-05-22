package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import cat.institutmarianao.domain.Doctor;
import cat.institutmarianao.domain.User;
import cat.institutmarianao.domain.repository.DoctorRepository;

@Repository
public class InMemoryDoctorRepositoryImpl implements DoctorRepository {

	private final Map<String, Doctor> listOfDoctors = new HashMap<String, Doctor>();

	public InMemoryDoctorRepositoryImpl() {

		Calendar albertoBornDate = new GregorianCalendar(1997, 7, 31);
		Doctor doctor1 = new Doctor("12345678T", "Alberto", "BEMA12345", albertoBornDate, "Male", "alberto@hotmail.com",
				"alberto123", "morning");

		Calendar ArnauBornDate = new GregorianCalendar(2000, 2, 21);
		Doctor doctor2 = new Doctor("95716847P", "Arnau", "ARNY77456", ArnauBornDate, "Male", "arny@hotmail.com",
				"11458874", "afternoon");

		Calendar AngelBornDate = new GregorianCalendar(1997, 2, 12);
		Doctor doctor3 = new Doctor("79411247P", "Angel", "MOCO56748", AngelBornDate, "Male",
				"angelon.megalodon@gmail.com", "angel321", "night");

		Calendar SandraBornDate = new GregorianCalendar(1992, 9, 26);
		Doctor doctor4 = new Doctor("95479321R", "Sandra", "MIRI87348", SandraBornDate, "Female",
				"sandra123.321@gmail.com", "sandrita", "morning");

		listOfDoctors.put("12345678T", doctor1);
		listOfDoctors.put("95716847P", doctor2);
		listOfDoctors.put("79411247P", doctor3);
		listOfDoctors.put("95479321R", doctor4);
	}

	@Override
	public List<Doctor> getAll() {
		return new ArrayList<Doctor>(listOfDoctors.values());
	}

	@Override
	public void add(Doctor doctor) {
		listOfDoctors.put(doctor.getDni(), doctor);

	}

	@Override
	public void update(Doctor doctor) {
		if (this.listOfDoctors.containsKey(doctor.getDni())) {
			User toUpdate = this.listOfDoctors.get(doctor.getDni());
			toUpdate.setEmail(doctor.getEmail());
			toUpdate.setPsswd(doctor.getPsswd());
		}
	}

	@Override
	public void delete(Doctor doctor) {
		if (this.listOfDoctors.containsKey(doctor.getDni())) {
			this.listOfDoctors.remove(doctor.getDni());
		}

	}

	@Override
	public Doctor getUserByDni(String dni) {
		return this.listOfDoctors.get(dni);
	}

	@Override
	public Doctor getuserByMediCard(String mediCard) {
		for (Doctor item : listOfDoctors.values()) {
			if (item.getMediCard().toUpperCase().contains(mediCard.toUpperCase())) {
				return item;
			}
		}
		throw new NoResultException("no se ha encontrado al usuario con el numero de mediCard=" + mediCard);
	}

}
