package es.institutmarianao.serviceweb.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.stereotype.Service;

import es.institutmarianao.domain.User;
import es.institutmarianao.serviceweb.UserWebService;

@Service
public class UserWebServiceImpl implements UserWebService {
	private static final Client client = ClientBuilder.newClient();

	@Override
	public User getUserByDni(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User newUserToAdd) {
		// TODO Auto-generated method stub

	}

}