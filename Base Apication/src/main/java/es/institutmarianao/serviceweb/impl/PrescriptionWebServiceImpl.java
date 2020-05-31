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

import es.institutmarianao.domain.Prescription;
import es.institutmarianao.serviceweb.PrescriptionWebService;

@Service
public class PrescriptionWebServiceImpl implements PrescriptionWebService {
	private static final String PATH_PRESCRIPTION = "http://localhost/TFGRestService/rest/prescriptions";
	private static final Client client = ClientBuilder.newClient();

	@Override
	public List<Prescription> getAll() {
		URI uri = UriBuilder.fromUri(PATH_PRESCRIPTION).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Prescription> returnedPrescriptions = res.readEntity(new GenericType<List<Prescription>>() {
		});
		return returnedPrescriptions;
	}

	@Override
	public void add(Prescription prescription) {
		URI uri = UriBuilder.fromUri(PATH_PRESCRIPTION).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(prescription, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void update(Prescription prescription) {
		URI uri = UriBuilder.fromUri(PATH_PRESCRIPTION).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPut(Entity.entity(prescription, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void delete(Prescription prescription) {
//		URI uri = UriBuilder.fromUri(PATH_PRESCRIPTION).port(8080).build();
//		WebTarget target = client.target(uri);
//		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
//				.buildDelete(Entity.entity(prescription, MediaType.APPLICATION_JSON));
//		invocation.invoke();
	}

	@Override
	public Prescription getPrescriptionByPrescriptionId(int prescriptionId) {
		URI uri = UriBuilder.fromUri(PATH_PRESCRIPTION).path("findByPrescriptionId")
				.path(String.valueOf(prescriptionId)).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Prescription returnedPrescription = res.readEntity(new GenericType<Prescription>() {
		});
		return returnedPrescription;
	}

}