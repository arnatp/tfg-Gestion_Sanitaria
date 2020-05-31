package es.institutmarianao.service;

import java.util.List;

import es.institutmarianao.domain.Visit;

public interface VisitService {

	List<Visit> getAll();

	void add(Visit visit);

	void update(Visit visit);

	void delete(Visit visit);

	Visit getVisitByVisitId(int visitId);

	List<Visit> getVisitsByPatientId(int patientId);

	List<Visit> getVisitsByDate(String date);

	List<Visit> getVisitsByDoctorId(int doctorId);

	List<Visit> getVisitsByDoctorIdAndDate(int doctorId, String date);

}
