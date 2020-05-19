package cat.institutmarianao.domain;

import java.util.Date;

public class Visits {

	private int visitId;
	private Date date;
	private String description;
	private Prescription prescription;
	private Doctor doctor;

	public Visits(String description, Prescription prescription, Doctor doctor) {
		this.date = new Date();
		this.description = description;
		this.prescription = prescription;
		this.doctor = doctor;
	}
}
