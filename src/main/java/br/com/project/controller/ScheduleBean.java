package br.com.project.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.models.Schedule;
import br.com.project.schedule.Gender;
import br.com.project.schedule.MaritalStatus;
import br.com.project.schedule.ScheduleRepositoryBean;
import br.com.project.schedule.ScheduleService;

@Named
@SessionScoped
public class ScheduleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;
	
	@Inject
	ScheduleRepositoryBean scheduleRepositoryBean;
	
	@Inject
	ScheduleService scheduleService;
	
	// Fields
	
	private String name;
	private Date birthDate;
	private String rg;
	private String cpf;	
	private String nationality;
	private Gender gender;
	private String stringGender;
	private String address;
	private String number;
	private String neighborhood;
	private String city;
	private String cep;
	private MaritalStatus maritalStatus;
	private String stringMaritalStatus;
	private String details;
	
	private Schedule schedule;
	
	public FacesContext getFacesContext() {
		return facesContext;
	}
	
	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
	
		this.nationality = nationality;
	}
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void newSchedule(){
		
		String name = this.name;
		Date birthDate = this.birthDate;
		String rg = this.rg;
		String cpf = this.cpf;	
		String nationality = this.nationality;
		Gender gender = this.gender;
		String address = this.address;
		String number = this.number;
		String neighborhood = this.neighborhood;
		String city = this.city;
		String cep = this.cep;
		String details = this.details;
		MaritalStatus maritalStatus = this.maritalStatus;
		
		scheduleService.createNewSchedule(name, birthDate, rg, cpf, nationality, gender, address, number, neighborhood, city, cep, details, maritalStatus);
		
//		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirmate Password Error !", "Password Error");
//		FacesContext.getCurrentInstance().addMessage(null, msg);

		
	}
	
	public void loadSchedule(){
		this.schedule = new Schedule();
	}
	
	public void saveEditSchedule(){
		
		String name = this.name;
		Date birthDate = this.birthDate;
		String rg = this.rg;
		String cpf = this.cpf;	
		String nationality = this.nationality;
		Gender gender = this.gender;
		String address = this.address;
		String number = this.number;
		String neighborhood = this.neighborhood;
		String city = this.city;
		String cep = this.cep;
		String details = this.details;
		
		MaritalStatus maritalStatus = this.maritalStatus;
		
		scheduleService.saveEditSchedule(name, birthDate, rg, cpf, nationality, gender, address, number, neighborhood, city, cep, details, maritalStatus);
		
	}
	
	public List<String> completText(String query) {
		List<String> match = new ArrayList<String>();
	    MaritalStatus[] units = MaritalStatus.values();
	    for (int i = 0; i < units.length; i++) {
	        if (units[i].name().contains(query))
	            match.add(units[i].getStatus());
	    }
	    return match;
	}
	
	public List<String> completTextGender(String query) {
		List<String> match = new ArrayList<String>();
	    Gender[] units = Gender.values();
	    for (int i = 0; i < units.length; i++) {
	        if (units[i].name().contains(query))
	            match.add(units[i].getGender());
	    }
	    return match;
	}

	public String getStringGender() {
		return stringGender;
	}

	public void setStringGender(String stringGender) {
		this.gender = Gender.valueOf(stringGender);
	}

	public String getStringMaritalStatus() {
		return stringMaritalStatus;
	}

	public void setStringMaritalStatus(String stringMaritalStatus) {
		this.maritalStatus = MaritalStatus.valueOf(stringMaritalStatus);
	}
	
}
