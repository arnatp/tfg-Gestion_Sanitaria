package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Visit visit;

	public Doctor(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd, String shift) {
		super(dni, name, mediCard, bornDate, gender, email, psswd, shift);
	}

	public Doctor() {
		// Constructor vacio para generar la tabla mediante JPA
	}

}
