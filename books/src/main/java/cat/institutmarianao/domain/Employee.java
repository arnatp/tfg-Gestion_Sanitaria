package cat.institutmarianao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Employee extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(max = 15)
	@Column(name = "shift", nullable = false, length = 15)
	private String shift;

	public Employee(String dni, String name, String mediCard, int bornYear, int bornMonth, int bornDate, String gender,
			String email, String psswd, String shift) {
		super(dni, name, mediCard, bornYear, bornMonth, bornDate, gender, email, psswd);
		this.shift = shift;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

}
