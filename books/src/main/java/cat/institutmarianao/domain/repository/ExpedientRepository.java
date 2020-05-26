package cat.institutmarianao.domain.repository;

import java.util.List;

import javax.ejb.Local;

import cat.institutmarianao.domain.Expedient;

@Local
public interface ExpedientRepository {

	List<Expedient> getAll();

	void add(Expedient expedient);

	void update(Expedient expedient);

	void delete(Expedient expedient);

	Expedient getExpedientByExpedientId(int expedientId);
}
