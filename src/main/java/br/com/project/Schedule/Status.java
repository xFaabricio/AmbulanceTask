package br.com.project.Schedule;

public enum Status {

	WAITING("Waiting"),
	READY("Ready"),
	FINISHED("Finished");
	
	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
