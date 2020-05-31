package es.institutmarianao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Prescription;
import es.institutmarianao.service.PrescriptionService;
import es.institutmarianao.serviceweb.PrescriptionWebService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionWebService prescriptionWebService;

	@Override
	public List<Prescription> getAll() {
		return prescriptionWebService.getAll();
	}

	@Override
	public void add(Prescription prescription) {
		prescriptionWebService.add(prescription);
	}

	@Override
	public void update(Prescription prescription) {
		prescriptionWebService.update(prescription);
	}

	@Override
	public void delete(Prescription prescription) {
		prescriptionWebService.delete(prescription);
	}

	@Override
	public Prescription getPrescriptionByPrescriptionId(int prescriptionId) {
		return prescriptionWebService.getPrescriptionByPrescriptionId(prescriptionId);
	}

}
