package es.institutmarianao.serviceweb;

import java.util.List;

import es.institutmarianao.domain.Prescription;

public interface PrescriptionWebService {

	List<Prescription> getAll();

	void add(Prescription prescription);

	void update(Prescription prescription);

	void delete(Prescription prescription);

	Prescription getPrescriptionByPrescriptionId(int prescriptionId);

}
