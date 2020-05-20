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

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getMedicamentName() {
		return medicamentName;
	}

	public void setMedicamentName(String medicamentName) {
		this.medicamentName = medicamentName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
