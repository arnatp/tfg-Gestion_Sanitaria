package cat.institutmarianao.domain;

import java.util.Date;

public class Doctor extends Personeel {

	public Doctor(String dni, String name, String mediCard, Date bornDate, String gender, String email, String psswd,
			String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

}
