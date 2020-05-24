package cat.institutmarianao.domain.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import cat.institutmarianao.domain.Doctor;
import cat.institutmarianao.domain.repository.DoctorRepository;

@Stateless
public class DoctorRepositoryImpl implements DoctorRepository {
	@PersistenceContext
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPersistenceUnit");
	private EntityManager entityManager = emf.createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getAll() {
		return entityManager.createQuery("select u from Doctor u").getResultList();
	}

	@Override
	public void add(Doctor doctor) {
		entityManager.persist(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		entityManager.merge(doctor);
	}

	@Override
	public void delete(Doctor doctor) {

		Doctor doctor1 = entityManager.merge(doctor);
		entityManager.remove(doctor1);
	}

	@Override
	public Doctor getUserByDni(String dni) {
		try {
			return (Doctor) entityManager.createQuery("select u from Doctor u where u.dni = :dni")
					.setParameter("dni", dni).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Doctor getuserByMediCard(String mediCard) {
		try {
			return (Doctor) entityManager.createQuery("select u from Doctor u where u.mediCard = :mediCard")
					.setParameter("mediCard", mediCard).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}