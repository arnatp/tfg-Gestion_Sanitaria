package es.institutmarianao.service.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.institutmarianao.domain.User;
import es.institutmarianao.service.DoctorWebService;
import es.institutmarianao.service.PatientWebService;
import es.institutmarianao.service.UserWebService;

@Component
public class UserWebServiceImpl implements UserWebService {
	private static final Client client = ClientBuilder.newClient();

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

	@Override
	public void update(User newUserToAdd) {
		// TODO Auto-generated method stub

	}

}