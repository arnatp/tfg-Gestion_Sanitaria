package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5416039502082691004L;
	private static final String DNIREGEXP = "\\d{8}[A-HJ-NP-TV-Z]";
	private static final String GENDERREGEXP = "[H,M]";
	private static final String EMAILREGEXP = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;

	@NotNull
	@Size(max = 9)
	@Pattern(regexp = DNIREGEXP)
	@Column(name = "dni", length = 9)
	private String dni;

	@NotNull
	@Size(max = 25)
	@Column(name = "name")
	private String name;

	@NotNull
	@Size(max = 9)
	@Column(name = "medicard")
	private String mediCard;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "borndate")
	private Calendar bornDate;

	@NotNull
	@Size(max = 1)
	@Pattern(regexp = GENDERREGEXP)
	@Column(name = "gender")
	private String gender;

	@NotNull
	@Size(max = 30)
	@Pattern(regexp = EMAILREGEXP)
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(max = 30, min = 5)
	@Column(name = "password")
	private String psswd;

	public User(String dni, String name, String mediCard, Calendar bornDate, String gender, String email,
			String psswd) {
		this.dni = dni;
		this.name = name;
		this.mediCard = mediCard;
		this.bornDate = bornDate;
		this.gender = gender;
		this.email = email;
		this.psswd = psswd;
	}

	public User() {
		// Constructor para poder crear las tablas con JPA
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

	public Calendar getBornDate() {
		return bornDate;
	}

	public void setBornDate(Calendar bornDate) {
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
