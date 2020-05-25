/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.institutmarianao.service.impl;

import java.awt.print.Book;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.User;
import es.institutmarianao.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Client client = ClientBuilder.newClient();

	@Autowired
	private UserService userRepository;

	@Override
	public List<User> getAll() {
		// Prepare the URI of the ws resource to test
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
		List<Book> returnedBooks = res.readEntity(new GenericType<List<Book>>() {
		});

	}

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User getUserByDni(String dni) {
		return userRepository.getUserByDni(dni);
	}

	@Override
	public User getuserByMediCard(String mediCard) {
		return userRepository.getuserByMediCard(mediCard);
	}
}
