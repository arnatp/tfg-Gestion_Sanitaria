package es.institutmarianao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Visit;
import es.institutmarianao.service.VisitService;
import es.institutmarianao.serviceweb.VisitWebService;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	VisitWebService visitWebService;

	@Override
	public List<Visit> getAll() {
		return visitWebService.getAll();
	}

	@Override
	public void add(Visit newVisitToAdd) {
		visitWebService.add(newVisitToAdd);
	}

	@Override
	public void update(Visit visit) {
		visitWebService.update(visit);

	}

	@Override
	public void delete(Visit visit) {
		visitWebService.delete(visit);
	}

	@Override
	public Visit getVisitByVisitId(int visitId) {
		return visitWebService.getVisitByVisitId(visitId);
	}

	@Override
	public List<Visit> getVisitsByPatientId(int patientId) {
		return visitWebService.getVisitsByPatientId(patientId);
	}

	@Override
	public List<Visit> getVisitsByDate(String date) {
		return visitWebService.getVisitsByDate(date);
	}

	@Override
	public List<Visit> getVisitsByDoctorId(int doctorId) {
		return visitWebService.getVisitsByDoctorId(doctorId);
	}

	@Override
	public List<Visit> getVisitsByDoctorIdAndDate(int doctorId, String date) {
		return visitWebService.getVisitsByDoctorIdAndDate(doctorId, date);
	}

	@Override
	public List<Visit> getVisitsCompletedByPatientId(int patientId) {
		return visitWebService.getVisitsCompletedByPatientId(patientId);
	}

}
