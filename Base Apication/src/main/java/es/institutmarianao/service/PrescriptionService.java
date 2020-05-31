package es.institutmarianao.service;

import java.util.List;

import es.institutmarianao.domain.Prescription;

public interface PrescriptionService {

	List<Prescription> getAll();

	void add(Prescription prescription);

	void update(Prescription prescription);

	void delete(Prescription prescription);

	Prescription getPrescriptionByPrescriptionId(int prescriptionId);

}
