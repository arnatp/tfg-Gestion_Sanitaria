package es.institutmarianao.domain;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int visitId;

	private Boolean completed = false;

	private Date date;

	private String description;

	private Prescription prescription = null;

	private Doctor doctor;

	public Visit(String description, Prescription prescription, Doctor doctor) {
		date = new Date();
		this.description = description;
		this.prescription = prescription;
		this.doctor = doctor;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
