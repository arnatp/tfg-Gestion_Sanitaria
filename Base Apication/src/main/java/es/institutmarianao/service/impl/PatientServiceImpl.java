package es.institutmarianao.service.impl;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Component;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.service.PatientService;

@Component
public class PatientServiceImpl implements PatientService {
	private static final Client client = ClientBuilder.newClient();
	private static final String PATH_DOCTOR = "http://localhost/TFGRestService/rest/patients";

	/*
	 * @Autowired private PatientWebService patientWebService;
	 */

	@Override
	public void addPatient(Patient patient) {
		// patientWebService.add(patient);

		URI uri = UriBuilder.fromUri("http://localhost/TFGRestService/rest/patients").port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(patient, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

}
