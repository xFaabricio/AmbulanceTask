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

import br.com.project.models.User;
import br.com.project.user.UserRepositoryBean;
import br.com.project.user.UserService;


@ManagedBean
@ViewScoped
@Named
public class UserController extends AbstractController<User> implements Serializable {

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    @Inject
    UserRepositoryBean userRepositoryBean;
    
    @Inject
    private UserService service;
    
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleSystem");

    List<User> users;
    
    /**
     *
     */
    protected EntityManager entityManager;
    
    
    /**
     *
     */
    public UserController() {
        super(User.class);
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
		this.users = service.getUsers();	
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	/**
     *
     * @param menuController
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

   

}
