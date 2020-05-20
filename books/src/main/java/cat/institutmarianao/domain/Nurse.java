package cat.institutmarianao.domain;

import java.util.Calendar;

public class Nurse extends Personeel {

	public Nurse(String dni, String name, String mediCard, Calendar bornDate, String gender, String email, String psswd,
			String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

}
