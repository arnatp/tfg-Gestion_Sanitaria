package es.institutmarianao.serviceweb.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Visit;
import es.institutmarianao.serviceweb.VisitWebService;

@Service
public class VisitWebServiceImpl implements VisitWebService {

	@Override
	public List<Visit> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Visit visit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Visit visit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Visit visit) {
		// TODO Auto-generated method stub

	}

	@Override
	public Visit getVisitByVisitId(int visitId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> getVisitsByPatientId(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> getVisitsByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> getVisitsByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visit> getVisitsByDoctorIdAndDate(int doctorId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
