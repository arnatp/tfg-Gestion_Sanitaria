package es.institutmarianao.service.impl;

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
	public Doctor getUserByDni(String name) {
		return doctorWebService.getUserByDni(name);
	}

}
