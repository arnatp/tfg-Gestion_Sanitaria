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

import es.institutmarianao.domain.Visit;
import es.institutmarianao.serviceweb.VisitWebService;

@Service
public class VisitWebServiceImpl implements VisitWebService {
	private static final Client client = ClientBuilder.newClient();
	private static final String PATH_VISITS = "http://localhost/TFGRestService/rest/visits";

	@Override
	public List<Visit> getAll() {
		URI uri = UriBuilder.fromUri(PATH_VISITS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Visit> returnedVisits = res.readEntity(new GenericType<List<Visit>>() {
		});
		return returnedVisits;
	}

	@Override
	public void add(Visit visit) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(visit, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void update(Visit visit) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPut(Entity.entity(visit, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void delete(Visit visit) {
//		URI uri = UriBuilder.fromUri(PATH_VISITS).port(8080).build();
//		WebTarget target = client.target(uri);
//		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
//				.buildDelete(Entity.entity(visit, MediaType.APPLICATION_JSON));
//		invocation.invoke();

	}

	@Override
	public Visit getVisitByVisitId(int visitId) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).path("findByVisitId").path(String.valueOf(visitId)).port(8080)
				.build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		Visit returnedVisit = res.readEntity(new GenericType<Visit>() {
		});
		return returnedVisit;
	}

	@Override
	public List<Visit> getVisitsByPatientId(int patientId) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).path("findByPatientId").path(String.valueOf(patientId)).port(8080)
				.build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Visit> returnedVisit = res.readEntity(new GenericType<List<Visit>>() {
		});
		return returnedVisit;
	}

	@Override
	public List<Visit> getVisitsByDate(String date) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).path("findByDate").path(date).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Visit> returnedVisit = res.readEntity(new GenericType<List<Visit>>() {
		});
		return returnedVisit;
	}

	@Override
	public List<Visit> getVisitsByDoctorId(int doctorId) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).path("findByDoctorId").path(String.valueOf(doctorId)).port(8080)
				.build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Visit> returnedVisit = res.readEntity(new GenericType<List<Visit>>() {
		});
		return returnedVisit;
	}

	@Override
	public List<Visit> getVisitsByDoctorIdAndDate(int doctorId, String date) {
		URI uri = UriBuilder.fromUri(PATH_VISITS).path("findByDoctorId").path(String.valueOf(doctorId)).path("date")
				.path(date).port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Visit> returnedVisit = res.readEntity(new GenericType<List<Visit>>() {
		});
		return returnedVisit;
	}

}
