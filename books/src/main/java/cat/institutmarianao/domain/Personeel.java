package cat.institutmarianao.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Personeel")
public abstract class Personeel extends User {

	private String shift;

	public Personeel(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd, String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd);
		this.shift = shift;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

}
