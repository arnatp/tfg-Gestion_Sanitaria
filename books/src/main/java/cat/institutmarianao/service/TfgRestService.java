package cat.institutmarianao.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cat.institutmarianao.domain.User;
import cat.institutmarianao.domain.repository.UserRepository;
import cat.institutmarianao.domain.repository.impl.InMemoryUserRepositoryImpl;

@Path("/tfg")

public class TfgRestService {
	private UserRepository userRepository = new InMemoryUserRepositoryImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {

		return userRepository.getAll();

	}
}
