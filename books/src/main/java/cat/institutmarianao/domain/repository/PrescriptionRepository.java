package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.Prescription;

public interface PrescriptionRepository {

	List<Prescription> getAll();

	void add(Prescription prescription);

	void update(Prescription prescription);

	void delete(Prescription prescription);

}
