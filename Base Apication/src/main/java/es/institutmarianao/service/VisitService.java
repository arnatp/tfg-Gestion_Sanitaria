package es.institutmarianao.service;

import java.util.Date;
import java.util.List;

import es.institutmarianao.domain.Expedient;
import es.institutmarianao.domain.Visit;

public interface VisitService {

	List<Visit> getAll();

	void add(Visit visit);

	void update(Visit visit);

	void delete(Visit visit);

	List<Visit> getVisitByExpedient(Expedient expedient);

	List<Visit> getVisitByDate(Date date);
}
