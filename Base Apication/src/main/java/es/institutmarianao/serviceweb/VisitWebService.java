package es.institutmarianao.serviceweb;

import java.util.List;

import es.institutmarianao.domain.Visit;

public interface VisitWebService {

	List<Visit> getAll();

	void add(Visit visit);

	void update(Visit visit);

	void delete(int visitId);

	Visit getVisitByVisitId(int visitId);

	List<Visit> getVisitsByPatientId(int patientId);

	List<Visit> getVisitsByDate(String date);

	List<Visit> getVisitsByDoctorId(int doctorId);

	List<Visit> getVisitsByDoctorIdAndDate(int doctorId, String date);

	List<Visit> getVisitsCompletedByPatientId(int patientId);

	List<Visit> getIncompletedVisitsByPatientId(int patientId);

	List<Visit> getIncompletedVisitsByDoctorIdAndDate(int doctorId, String date);

}
