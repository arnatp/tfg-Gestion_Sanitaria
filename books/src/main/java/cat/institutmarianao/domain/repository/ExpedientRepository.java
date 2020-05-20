package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.Expedient;

public interface ExpedientRepository {

	List<Expedient> getAll();

	void add(Expedient expedient);

	void update(Expedient expedient);

	void delete(Expedient expedient);

}
