package cat.institutmarianao.domain;

public class Prescription {

	private int prescriptionId;
	private String medicamentName;
	private int quantity;
	private String schedule;

	public Prescription(String medicamentName, int quantity, String schedule) {
		this.medicamentName = medicamentName;
		this.quantity = quantity;
		this.schedule = schedule;
	}

}
