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

import br.com.project.models.Group;
import br.com.project.user.GroupRepositoryBean;


@ManagedBean
@ViewScoped
@Named
public class GroupController extends AbstractController<Group> implements Serializable {

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    @Inject
    GroupRepositoryBean groupRepositoryBean;
    
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleSystem");

    List<Group> groups;
    
    /**
     *
     */
    protected EntityManager entityManager;
    
    
    /**
     *
     */
    public GroupController() {
        super(Group.class);
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

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@PostConstruct
	public void init(){
		this.groups = groupRepositoryBean.groups();	
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
