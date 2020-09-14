package br.com.project.schedule;

public enum MaritalStatus {

	MARRIED("Married"),
	SINGLE("Single");
	
	private final String status;

	private MaritalStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
