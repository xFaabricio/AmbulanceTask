package br.com.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.project.Schedule.ScheduleRepositoryBean;
import br.com.project.models.Schedule;


@ManagedBean
@ViewScoped
@Named
public class ScheduleController extends AbstractController<Schedule> implements Serializable {

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    @Inject
    ScheduleRepositoryBean scheduleRepositoryBean;
    
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleSystem");

    List<Schedule> schedules;
    
    /**
     *
     */
    protected EntityManager entityManager;
    
    
    /**
     *
     */
    public ScheduleController() {
        super(Schedule.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public MenuController getMenuController() {
        return menuController;
    }

    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PostConstruct
	public void init(){
		this.schedules = scheduleRepositoryBean.findSchedules();	
	}

	public ScheduleRepositoryBean getScheduleRepositoryBean() {
		return scheduleRepositoryBean;
	}

	public void setScheduleRepositoryBean(ScheduleRepositoryBean scheduleRepositoryBean) {
		this.scheduleRepositoryBean = scheduleRepositoryBean;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	/**
     *
     * @param menuController
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

   

}
