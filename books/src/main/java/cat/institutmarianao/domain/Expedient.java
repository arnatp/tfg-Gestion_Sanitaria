package cat.institutmarianao.domain;

import java.util.LinkedList;
import java.util.List;

public class Expedient {

	private int ExpedientId;
	private List<Visit> history;

	public Expedient() {
		history = new LinkedList<Visit>();
	}

	public int getExpedientId() {
		return ExpedientId;
	}

	public void setExpedientId(int expedientId) {
		ExpedientId = expedientId;
	}

	public List<Visit> getHistory() {
		return history;
	}

	public void setHistory(List<Visit> history) {
		this.history = history;
	}

}
