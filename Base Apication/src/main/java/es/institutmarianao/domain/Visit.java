package es.institutmarianao.domain;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int visitId;

	private Boolean completed = false;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	private String initialDescription;

	private String resolution;

	private Prescription prescription = null;

	private Doctor doctor;

	private Patient patient;

	/*
	 * public Visit(String description, Prescription prescription, Doctor doctor) {
	 * date = new Date(); this.description = description; this.prescription =
	 * prescription; this.doctor = doctor; }
	 */

	public Visit() {
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInitialDescription() {
		return initialDescription;
	}

	public void setInitialDescription(String description) {
		initialDescription = description;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
