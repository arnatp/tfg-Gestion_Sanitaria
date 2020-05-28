package es.institutmarianao.domain;

import java.io.Serializable;

public class Patient extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float height;
	private float weigth;

	public Patient(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, float height, float weigth) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd);
		this.height = height;
		this.weigth = weigth;
	}

	public Patient() {
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
