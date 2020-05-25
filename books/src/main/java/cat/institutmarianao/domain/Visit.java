package cat.institutmarianao.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "visit")
public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitId")
	private int visitId;

	@NotNull
	@Column(name = "completed", nullable = false)
	private Boolean completed = false;

	@NotNull
	@Column(name = "date", nullable = false, columnDefinition = "DATE")
	private LocalDate date;

	@NotNull
	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prescriptionId")
	private Prescription prescription = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "expedientId")
	private Expedient expedient;

	public Visit(String description, Prescription prescription, Doctor doctor) {
		date = LocalDate.now();
		this.description = description;
		this.prescription = prescription;
		this.doctor = doctor;
	}

	public Visit() {
		// Constructor vacío para poder crear la tabla mediante JPA
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
