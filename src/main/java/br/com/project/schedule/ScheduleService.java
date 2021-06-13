package br.com.project.schedule;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.project.models.Schedule;
import br.com.project.system.Security;

@Named
@ApplicationScoped
public class ScheduleService implements Serializable{
	
	@Inject
	private EntityManager manager;
	
	@Inject
	ScheduleRepositoryBean scheduleRepositoryBean;
	
	private Schedule schedule;
	
	@Inject
	Security security;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void saveEditSchedule(String name, Date birthDate, String rg, String cpf, String nationality, Gender gender, 
			String address, String number, String neighborhood, String CITY, String CEP, String details, MaritalStatus maritalStatus){
		
		EntityTransaction entityTransaction = manager.getTransaction();
		
		try {
		
			entityTransaction.begin();
			
			schedule.setName(name);
			schedule.setBirthDate(birthDate);
			schedule.setRg(rg);
			schedule.setCpf(cpf);
			schedule.setNationality(nationality);
			schedule.setGender(gender);
			schedule.setAddress(address);
			schedule.setNumber(number);
			schedule.setNeighborhood(neighborhood);
			schedule.setCITY(CITY);
			schedule.setCEP(CEP);
			schedule.setDetails(details);
			
			schedule.setUser(security.getLoggedUser().getUser());
			
			this.manager.persist(schedule);
			
			entityTransaction.commit();
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Schedule Created", "Schedule Create. Please try logging in.");
		    FacesContext.getCurrentInstance().addMessage(null, msg);	
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Schedule Create Error", "Schedule not Create. Try Again");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	}
	
	public void createNewSchedule(String name, Date birthDate, String rg, String cpf, String nationality, Gender gender, 
			String address, String number, String neighborhood, String CITY, String CEP, String details, MaritalStatus maritalStatus){
		
		EntityTransaction entityTransaction = manager.getTransaction();
		
		try {
			
			entityTransaction.begin();
			
			schedule = new Schedule();
			
			schedule.setName(name);
			schedule.setBirthDate(birthDate);
			schedule.setRg(rg);
			schedule.setCpf(cpf);
			schedule.setNationality(nationality);
			schedule.setGender(gender);
			schedule.setAddress(address);
			schedule.setNumber(number);
			schedule.setNeighborhood(neighborhood);
			schedule.setCITY(CITY);
			schedule.setCEP(CEP);
			schedule.setMaritalStatus(maritalStatus);
			schedule.setDetails(details);
			schedule.setStatus(Status.WAITING);
			schedule.setUser(security.getLoggedUser().getUser());
			
			this.manager.persist(schedule);
			
			entityTransaction.commit();
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Schedule Created", "Schedule Create. Please try logging in.");
		    FacesContext.getCurrentInstance().addMessage(null, msg);	
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Schedule Create Error", "Schedule not Create. Try Again");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
	
//	public List<User> createViewToUser(String login){
//		return userRepositoryBean.findUsersBasedOnGroup(login);
//	}
	
	public List<Schedule> getSchedules(){		
		return scheduleRepositoryBean.findSchedules();
	}
	
}
