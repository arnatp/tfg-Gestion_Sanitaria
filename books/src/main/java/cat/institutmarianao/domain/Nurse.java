package cat.institutmarianao.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
public class Nurse extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Nurse(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, String shift) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd, shift);
	}

	public Nurse() {
		// Constructor vacio para poder crear la tabla mediante JPA
	}

}
