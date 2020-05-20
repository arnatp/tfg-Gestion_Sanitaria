package cat.institutmarianao.domain.repository;

import java.util.Date;
import java.util.List;

import cat.institutmarianao.domain.Expedient;
import cat.institutmarianao.domain.Visit;

public interface VisitRepository {

	List<Visit> getAll();

	void add(Visit visit);

	void update(Visit visit);

	void delete(Visit visit);

	List<Visit> getVisitByExpedient(Expedient expedient);

	List<Visit> getVisitByDate(Date date);
}
