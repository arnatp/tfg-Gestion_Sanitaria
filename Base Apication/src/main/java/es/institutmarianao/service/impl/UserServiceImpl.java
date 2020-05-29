package es.institutmarianao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.User;
import es.institutmarianao.service.UserService;
import es.institutmarianao.serviceweb.DoctorWebService;
import es.institutmarianao.serviceweb.PatientWebService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PatientWebService patientWebService;
	@Autowired
	private DoctorWebService doctorWebService;

	@Override
	public User getUserByDni(String name) {
		User user = patientWebService.getUserByDni(name);
		if (user != null) {
			return user;
		}
		user = doctorWebService.getUserByDni(name);
		if (user != null) {
			return user;
		}
		return null;
	}

}
