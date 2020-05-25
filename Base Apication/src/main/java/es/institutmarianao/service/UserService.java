package es.institutmarianao.service;

import java.util.List;

import es.institutmarianao.domain.User;

public interface UserService {

	List<User> getAll();

	void addUser(User user);

	void update(User user);

	User getUserByDni(String dni);

	User getuserByMediCard(String mediCard);

}
