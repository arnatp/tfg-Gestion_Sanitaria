package cat.institutmarianao.domain;

import java.util.LinkedList;
import java.util.List;

public class Expedient {

	private int ExpedientId;
	private List<Visits> history;

	public Expedient() {
		this.history = new LinkedList<Visits>();
	}
}
