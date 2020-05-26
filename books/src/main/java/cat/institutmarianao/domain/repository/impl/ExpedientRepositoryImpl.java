package cat.institutmarianao.domain.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import cat.institutmarianao.domain.Expedient;
import cat.institutmarianao.domain.repository.ExpedientRepository;

/*TODO añadir named querys*/
@Stateless
public class ExpedientRepositoryImpl implements ExpedientRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Expedient> getAll() {
		return entityManager.createNamedQuery("Expedient.findAll").getResultList();
	}

	@Override
	public void add(Expedient expedient) {
		entityManager.persist(expedient);
	}

	@Override
	public void update(Expedient expedient) {
		entityManager.merge(expedient);
	}

	@Override
	public void delete(Expedient expedient) {
		Expedient expedient1 = entityManager.merge(expedient);
		entityManager.remove(expedient1);
	}

	@Override
	public Expedient getExpedientByExpedientId(int expedientId) {
		try {
			return (Expedient) entityManager.createNamedQuery("Expedient.findByExpedientId")
					.setParameter("expedientId", expedientId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}