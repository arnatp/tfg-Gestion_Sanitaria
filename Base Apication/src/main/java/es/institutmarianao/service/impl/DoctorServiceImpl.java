package es.institutmarianao.service.impl;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Component;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.service.DoctorService;

@Component
public class DoctorServiceImpl implements DoctorService {
	private static final String PATH_DOCTOR = "http://localhost/TFGRestService/rest/doctors";
	private static final Client client = ClientBuilder.newClient();

	@Override
	public List<Doctor> getAll() {
		URI uri = UriBuilder.fromUri(PATH_DOCTOR).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Doctor> returnedDoctors = res.readEntity(new GenericType<List<Doctor>>() {
		});
		return returnedDoctors;

	}

	@Override
	public void add(Doctor doctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Doctor doctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Doctor getUserByDni(String dni) {
		URI uri = UriBuilder.fromUri(PATH_DOCTOR).path("findByDni").path(dni).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Doctor returnedDoctor = res.readEntity(new GenericType<Doctor>() {
		});
		return returnedDoctor;
	}

	@Override
	public Doctor getuserByMediCard(String mediCard) {
		// TODO Auto-generated method stub
		return null;
	}

}