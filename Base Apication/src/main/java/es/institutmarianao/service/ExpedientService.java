package es.institutmarianao.service;

import java.util.List;

import cat.institutmarianao.domain.Expedient;

public interface ExpedientService {

	List<Expedient> getAll();

	void add(Expedient expedient);

	void update(Expedient expedient);

	void delete(Expedient expedient);

}
