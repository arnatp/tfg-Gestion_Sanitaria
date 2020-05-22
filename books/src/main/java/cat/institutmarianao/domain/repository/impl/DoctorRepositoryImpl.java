package cat.institutmarianao.domain.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import cat.institutmarianao.domain.User;
import cat.institutmarianao.domain.repository.UserRepository;

@Stateless
public class DoctorRepositoryImpl implements UserRepository {

	public EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return entityManager.createQuery("select u from User u ").getResultList();
	}

	@Override
	public void add(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(User user) {

		User user1 = entityManager.merge(user);
		entityManager.remove(user1);
	}

	@Override
	public User getUserByDni(String dni) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.dni = :dni").setParameter("dni", dni)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User getuserByMediCard(String mediCard) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.mediCard = :mediCard")
					.setParameter("mediCard", mediCard).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}