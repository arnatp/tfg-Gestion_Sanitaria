package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patient")
public class Patient extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expedientId")
	private Expedient expedient;

	@NotNull
	@Column(name = "height", nullable = false)
	private float height;

	@NotNull
	@Column(name = "weigth", nullable = false)
	private float weigth;

	public Patient(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd, float height, float weigth) {
		super(dni, name, mediCard, bornDate, gender, email, psswd);
		expedient = new Expedient();
		this.height = height;
		this.weigth = weigth;
	}

	public Patient() {
		// Constructor vacio para poder crear las tablas en JPA
	}

	public Expedient getExpedient() {
		return expedient;
	}

	public void setExpedient(Expedient expedient) {
		this.expedient = expedient;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeigth() {
		return weigth;
	}

	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

}
