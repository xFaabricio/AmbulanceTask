package br.com.project.schedule;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.project.models.Schedule;

public class ScheduleRepositoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Schedule> findSchedules() {
		return this.manager.createQuery("from Schedule", Schedule.class)
				.getResultList();
	}

}
