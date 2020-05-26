package es.institutmarianao.service.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.stereotype.Component;

import es.institutmarianao.domain.User;
import es.institutmarianao.service.UserService;

@Component
public class UserServiceImpl implements UserService {
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