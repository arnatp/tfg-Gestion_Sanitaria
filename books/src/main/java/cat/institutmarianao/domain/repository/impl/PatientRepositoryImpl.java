package cat.institutmarianao.domain.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import cat.institutmarianao.domain.Patient;
import cat.institutmarianao.domain.repository.PatientRepository;

/*TODO añadir named querys*/
@Stateless
public class PatientRepositoryImpl implements PatientRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getAll() {
		return entityManager.createQuery("select u from Patient u").getResultList();
	}

	@Override
	public void add(Patient patient) {
		entityManager.persist(patient);
	}

	@Override
	public void update(Patient patient) {
		entityManager.merge(patient);
	}

	@Override
	public void delete(Patient patient) {
		Patient patient1 = entityManager.merge(patient);
		entityManager.remove(patient1);
	}

	@Override
	public Patient getUserByDni(String dni) {
		try {
			return (Patient) entityManager.createQuery("select u from Patient u where u.dni = :dni")
					.setParameter("dni", dni).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Patient getUserByMediCard(String mediCard) {
		try {
			return (Patient) entityManager.createQuery("select u from Patient u where u.mediCard = :mediCard")
					.setParameter("mediCard", mediCard).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}