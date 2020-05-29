package es.institutmarianao.service.impl;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Component;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.service.PatientWebService;

@Component
public class PatientWebServiceImpl implements PatientWebService {
	private static final Client client = ClientBuilder.newClient();
	private static final String PATH_PATIENT = "http://localhost/TFGRestService/rest/patients";

	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Patient patient) {
		URI uri = UriBuilder.fromUri(PATH_PATIENT).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(patient, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void update(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public Patient getUserByDni(String username) {
		URI uri = UriBuilder.fromUri(PATH_PATIENT).path("findByDni").path(username).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Patient returnedPatient = res.readEntity(new GenericType<Patient>() {
		});
		return returnedPatient;
	}

	@Override
	public Patient getUserByMediCard(String mediCard) {
		// TODO Auto-generated method stub
		return null;
	}

}
