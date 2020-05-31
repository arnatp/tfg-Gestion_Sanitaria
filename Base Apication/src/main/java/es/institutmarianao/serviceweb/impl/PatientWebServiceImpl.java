package es.institutmarianao.serviceweb.impl;

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

import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.serviceweb.PatientWebService;

@Service
public class PatientWebServiceImpl implements PatientWebService {
	private static final Client client = ClientBuilder.newClient();
	private static final String PATH_PATIENTS = "http://localhost/TFGRestService/rest/patients";

	@Override
	public List<Patient> getAll() {
		URI uri = UriBuilder.fromUri(PATH_PATIENTS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Patient> returnedPatients = res.readEntity(new GenericType<List<Patient>>() {
		});
		return returnedPatients;
	}

	@Override
	public void add(Patient patient) {
		URI uri = UriBuilder.fromUri(PATH_PATIENTS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(patient, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void update(Patient patient) {
		URI uri = UriBuilder.fromUri(PATH_PATIENTS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPut(Entity.entity(patient, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void delete(Patient patient) {
//		URI uri = UriBuilder.fromUri(PATH_PATIENTS).port(8080).build();
//		WebTarget target = client.target(uri);
//		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
//				.buildDelete(Entity.entity(patient, MediaType.APPLICATION_JSON));
//		invocation.invoke();
	}

	@Override
	public Patient getUserByDni(String username) {
		URI uri = UriBuilder.fromUri(PATH_PATIENTS).path("findByDni").path(username).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Patient returnedPatient = res.readEntity(new GenericType<Patient>() {
		});
		return returnedPatient;
	}

	@Override
	public Patient getUserByMediCard(String mediCard) {
		URI uri = UriBuilder.fromUri(PATH_PATIENTS).path("findByMediCard").path(mediCard).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Patient returnedPatient = res.readEntity(new GenericType<Patient>() {
		});
		return returnedPatient;
	}

}
