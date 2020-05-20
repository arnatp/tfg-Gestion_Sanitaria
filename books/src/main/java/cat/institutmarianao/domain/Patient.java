package cat.institutmarianao.domain;

import java.util.Date;

public class Patient extends User {

	private Expedient expedient;
	private float height;
	private float weigth;

	public Patient(String dni, String name, String mediCard, Date bornDate, String gender, String email, String psswd,
			float height, float weigth) {
		super(dni, name, mediCard, bornDate, gender, email, psswd);
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

}
