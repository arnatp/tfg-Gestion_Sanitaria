package cat.institutmarianao.domain;

import java.util.Date;
import java.util.Objects;

//@Entity
//@Table(name="Users")

public abstract class User {

	private String dni;
	private String name;
	private String mediCard;
	private Date bornDate;
	private String gender;
	private String email;
	private String psswd;

	public User(String dni, String name, String mediCard, Date bornDate, String gender, String email, String psswd) {
		this.dni = dni;
		this.name = name;
		this.mediCard = mediCard;
		this.bornDate = bornDate;
		this.gender = gender;
		this.email = email;
		this.psswd = psswd;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMediCard() {
		return mediCard;
	}

	public void setMediCard(String mediCard) {
		this.mediCard = mediCard;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsswd() {
		return psswd;
	}

	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(dni, other.dni);
	}
}
