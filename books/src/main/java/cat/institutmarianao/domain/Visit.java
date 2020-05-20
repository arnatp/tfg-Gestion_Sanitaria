package cat.institutmarianao.domain;

import java.util.Date;

public class Visit {

	private int visitId;
	private Date date;
	private String description;
	private Prescription prescription;
	private Doctor doctor;

	public Visit(String description, Prescription prescription, Doctor doctor) {
		date = new Date();
		this.description = description;
		this.prescription = prescription;
		this.doctor = doctor;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
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
