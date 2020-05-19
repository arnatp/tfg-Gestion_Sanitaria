package cat.institutmarianao.domain;

import java.util.Date;

public class Nurse extends Personeel {

	public Nurse(String dni, String name, String mediCard, Date bornDate, String gender, String email, String psswd,
			String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

}
