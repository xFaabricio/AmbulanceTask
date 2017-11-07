package br.com.project.Schedule;

public enum Gender {

	FEMALE("Female"),
	MALE("Male");
	
	private final String gender;

	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
}
