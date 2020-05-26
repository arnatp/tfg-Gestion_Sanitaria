package es.institutmarianao.domain;

import java.io.Serializable;

public class Doctor extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Doctor(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, String shift) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd, shift);
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

}
