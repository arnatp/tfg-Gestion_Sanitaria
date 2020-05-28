package es.institutmarianao.service.impl;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
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

import es.institutmarianao.domain.Expedient;
import es.institutmarianao.service.ExpedientService;

@Service
@Transactional
public class ExpedientServiceImpl implements ExpedientService {
	private static final Client client = ClientBuilder.newClient();

	@Override
	public List<Expedient> getAll() {
		URI uri = UriBuilder.fromUri("http://localhost/TFGRestService/rest/expedients").port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
		Response res = invocation.invoke();
		List<Expedient> returnedExpedients = res.readEntity(new GenericType<List<Expedient>>() {
		});

		return returnedExpedients;
	}

	@Override
	public void add(Expedient newExpedient) {
		URI uri = UriBuilder.fromUri("http://localhost/TFGRestService/rest/expedients").port(8080).build();
		WebTarget target = client.target(uri);
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildPost(Entity.entity(newExpedient, MediaType.APPLICATION_JSON));
		invocation.invoke();
	}

	@Override
	public void update(Expedient expedient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Expedient expedient) {
		// TODO Auto-generated method stub

	}

}
