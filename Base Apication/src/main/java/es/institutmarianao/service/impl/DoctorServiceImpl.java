package es.institutmarianao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.service.DoctorService;
import es.institutmarianao.serviceweb.DoctorWebService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorWebService doctorWebService;

	@Override
	public List<Doctor> getAll() {
		return doctorWebService.getAll();
	}

	@Override
	public void add(Doctor doctor) {
		doctorWebService.add(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		doctorWebService.update(doctor);

	}

	@Override
	public void delete(Doctor doctor) {
		doctorWebService.delete(doctor);
	}

	@Override
	public Doctor getUserByDni(String name) {
		return doctorWebService.getUserByDni(name);
	}

	@Override
	public Doctor getUserByMediCard(String mediCard) {
		return doctorWebService.getuserByMediCard(mediCard);
	}

}
