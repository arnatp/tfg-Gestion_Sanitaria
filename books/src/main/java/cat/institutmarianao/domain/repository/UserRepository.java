package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.User;

public interface UserRepository {

	List<User> getAll();

	void add(User user);

	User update(User user);

	void delete(User user);

	User getUserByDni(String dni);

	User getuserByMediCard(String mediCard);

}
