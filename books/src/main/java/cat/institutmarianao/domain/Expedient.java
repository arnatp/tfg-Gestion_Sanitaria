package cat.institutmarianao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expedient")
public class Expedient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expedientId")
	private int expedientId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "visitId")
	private List<Visit> history = new ArrayList<Visit>();

	@OneToOne(mappedBy = "expedient", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Patient patient;

	public Expedient() {
	}

	public int getExpedientId() {
		return expedientId;
	}

	public void setExpedientId(int expedientId) {
		this.expedientId = expedientId;
	}

	public List<Visit> getHistory() {
		return history;
	}

	public void setHistory(List<Visit> history) {
		this.history = history;
	}

}
