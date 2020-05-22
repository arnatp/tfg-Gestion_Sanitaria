package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "auxiliar")
public class Auxiliar extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Auxiliar(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd, String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

	public Auxiliar() {
		// Constructor vacio para poder crear las tablas medienta JPA
	}

}
