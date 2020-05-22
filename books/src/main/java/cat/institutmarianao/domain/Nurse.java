package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
public class Nurse extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Nurse(String dni, String name, String mediCard, Calendar bornDate, String gender, String email, String psswd,
			String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

	public Nurse() {
		// Constructor vacio para poder crear la tabla mediante JPA
	}

}
