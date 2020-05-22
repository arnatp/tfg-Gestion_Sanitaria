package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import cat.institutmarianao.domain.User;
import cat.institutmarianao.domain.repository.UserRepository;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

	private final Map<String, User> listOfUsers = new HashMap<String, User>();

	public InMemoryUserRepositoryImpl() {

		Calendar albertoBornDate = new GregorianCalendar(1997, 7, 31);
		User user1 = new User("12345678T", "Alberto", "BEMA12345", albertoBornDate, "Male", "alberto@hotmail.com",
				"alberto123");

		Calendar ArnauBornDate = new GregorianCalendar(2000, 2, 21);
		User user2 = new User("95716847P", "Arnau", "ARNY77456", ArnauBornDate, "Male", "arny@hotmail.com", "11458874");

		Calendar AngelBornDate = new GregorianCalendar(1997, 2, 12);
		User user3 = new User("79411247P", "Angel", "MOCO56748", AngelBornDate, "Male", "angelon.megalodon@gmail.com",
				"angel321");

		Calendar SandraBornDate = new GregorianCalendar(1992, 9, 26);
		User user4 = new User("95479321R", "Sandra", "MIRI87348", SandraBornDate, "Female", "sandra123.321@gmail.com",
				"sandrita");

		listOfUsers.put("12345678T", user1);
		listOfUsers.put("95716847P", user2);
		listOfUsers.put("79411247P", user3);
		listOfUsers.put("95479321R", user4);
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(listOfUsers.values());
	}

	@Override
	public void add(User user) {
		this.listOfUsers.put(user.getDni(), user);

	}

	@Override
	public void update(User user) {
		if (this.listOfUsers.containsKey(user.getDni())) {
			User toUpdate = this.listOfUsers.get(user.getDni());
			toUpdate.setBornDate(user.getBornDate());
			toUpdate.setEmail(user.getEmail());
			toUpdate.setGender(user.getGender());
			toUpdate.setMediCard(user.getMediCard());
			toUpdate.setName(user.getName());
			toUpdate.setPsswd(user.getPsswd());
		}
	}

	@Override
	public void delete(User user) {
		if (this.listOfUsers.containsKey(user.getDni())) {
			this.listOfUsers.remove(user.getDni());
		}

	}

	@Override
	public User getUserByDni(String dni) {
		return this.listOfUsers.get(dni);
	}

	@Override
	public User getuserByMediCard(String mediCard) {
		for (User item : listOfUsers.values()) {
			if (item.getMediCard().toUpperCase().contains(mediCard.toUpperCase())) {
				return item;
			}
		}
		throw new NoResultException("no se ha encontrado al usuario con el numero de mediCard=" + mediCard);
	}

}
