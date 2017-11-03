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

import br.com.project.user.User;
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
    
	private Short id;

	private String login;

	private String email;
	
	private String password;

	private String name;
	
	private String lastName;
    
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
		
		for(int i=0; i < this.users.size(); i++){
			this.id = this.users.get(i).getId();
			this.login = this.users.get(i).getLogin();
			this.email = this.users.get(i).getEmail();
			this.password = this.users.get(i).getPassword();
			this.name = this.users.get(i).getName();
			this.lastName = this.users.get(i).getLastName();
		}
		
	}
	
//	public List<Object[]> formatObjects(List<Object[]> objects){
//		
//		List<Object[]> newRows = new ArrayList<Object[]>();
//		
//		for(Object[] row : objects){
//			
//			Object[] newRow = new Object[2];
//			if(row[0] != null){
//				newRow[0] = row[1];
//				newRow[1] = row[2];
//				newRow[2] = row[4];
//				
//				newRows.add(newRow);
//			}
//		}
//				
//		return newRows;
//	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
