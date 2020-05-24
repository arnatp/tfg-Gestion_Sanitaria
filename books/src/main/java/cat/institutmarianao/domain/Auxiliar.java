package cat.institutmarianao.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "auxiliar")
public class Auxiliar extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Auxiliar(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, String shift) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd, shift);
	}

	public Auxiliar() {
		// Constructor vacio para poder crear las tablas medienta JPA
	}

}
