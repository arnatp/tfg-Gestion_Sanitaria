package es.institutmarianao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Expedient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int expedientId;

	private List<Visit> history;

	public Expedient() {
		this.expedientId = 0;
		history = new ArrayList<Visit>();
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
