package es.institutmarianao.service;

import es.institutmarianao.domain.User;

public interface UserService {

	User getUserByDni(String name);

	void update(User newUserToAdd);

}
