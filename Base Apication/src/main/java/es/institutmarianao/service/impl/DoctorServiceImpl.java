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

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	private static final Client client = ClientBuilder.newClient();

	@Override
	public List<Doctor> getAll() {
		URI uri = UriBuilder.fromUri("http://localhost/books/rest/doctors").port(8080).build();
		// Prepare the web target to invoke, from the uri
		WebTarget target = client.target(uri);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using GET HTTP method
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		/* Act */
		// Do the invocation and get the response
		Response res = invocation.invoke();
		// Read the entity from the response in a list
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getuserByMediCard(String mediCard) {
		// TODO Auto-generated method stub
		return null;
	}

}