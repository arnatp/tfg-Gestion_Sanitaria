package es.institutmarianao.domain;

import java.io.Serializable;

public class Patient extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Expedient expedient;

	private float height;

	private float weigth;

	public Patient(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, float height, float weigth) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd);
		expedient = new Expedient();
		this.height = height;
		this.weigth = weigth;
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

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
