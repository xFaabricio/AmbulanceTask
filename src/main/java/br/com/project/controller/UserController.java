package br.com.project.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.project.user.User;


@ManagedBean
@ViewScoped
public class UserController extends AbstractController<User> implements java.io.Serializable {

    private static final long serialVersionUID = 3047947280907795325L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleSystem");

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

    /**
     * Sets the "items" attribute with a collection of FilmActor entities that
     * are retrieved from Actor?cap_first and returns the navigation outcome.
     *
     */
    public void navigateUsersList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User_items", this.entityManager.createNamedQuery("User.findAll").getResultList());
        }
        menuController.setPageLink("/user/index");
        menuController.setPageName("User List");
    }

}
