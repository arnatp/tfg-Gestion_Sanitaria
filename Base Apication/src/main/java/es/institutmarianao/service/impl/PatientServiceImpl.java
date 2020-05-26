package es.institutmarianao.service.impl;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.service.PatientService;

public class PatientServiceImpl implements PatientService {
	private static final Client client = ClientBuilder.newClient();

	@Override
	public void addPatient(Patient newPatientToAdd) {
		URI uri = UriBuilder.fromUri("http://localhost/books/rest/patients").port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(newPatientToAdd, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

}
