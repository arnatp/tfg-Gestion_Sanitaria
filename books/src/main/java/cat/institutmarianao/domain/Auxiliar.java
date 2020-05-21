package cat.institutmarianao.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "employeeId")
@Table(name = "auxiliar")
public class Auxiliar extends Employee {

	public Auxiliar(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd, String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

	public Auxiliar() {
		// Constructor vacio para poder crear las tablas medienta JPA
	}

}
