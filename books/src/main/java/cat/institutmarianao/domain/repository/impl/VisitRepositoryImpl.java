package cat.institutmarianao.domain.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import cat.institutmarianao.domain.Visit;
import cat.institutmarianao.domain.repository.VisitRepository;

/*TODO añadir named querys*/
@Stateless
public class VisitRepositoryImpl implements VisitRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getAll() {
		return entityManager.createQuery("select u from Visit u").getResultList();
	}

	@Override
	public void add(Visit visit) {
		entityManager.persist(visit);
	}

	@Override
	public void update(Visit visit) {
		entityManager.merge(visit);
	}

	@Override
	public void delete(Visit visit) {
		Visit visit1 = entityManager.merge(visit);
		entityManager.remove(visit1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getVisitsByExpedientId(int expedientId) {
		try {
			return entityManager.createQuery("select u from Visit u where u.expedientId = :expedientId")
					.setParameter("expedientId", expedientId).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getVisitsByDate(LocalDate date) {
		try {
			return entityManager.createQuery("select u from Visit u where u.date = :date").setParameter("date", date)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Visit getVisitByVisitId(int visitId) {
		try {
			return (Visit) entityManager.createQuery("select u from Visit u where u.visitId = :visitId")
					.setParameter("visitId", visitId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}