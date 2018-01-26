package br.com.project.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.models.User;
import br.com.project.user.UserRepositoryBean;
import br.com.project.user.UserService;
import br.com.project.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;
	
	private User user;
	
	private String name;
	
	private String lastName;
	
	private String password;
		
	private String email;
	
	private String confirmatePassword;
	
	@Inject
	UserService userService;
	
	@Inject
	UserRepositoryBean userRepositoryBean;
	
	private String login;
	
	private String newLogin;
	
	private String editLogin;

	public void preRender() {
		if ("true".equals(request.getParameter("accessInvalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
		}
	}
	
	public void loginAccess() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
		facesContext.responseComplete();
	}
	
	public void loadUser(){
		this.user = new User();
	}
	
	public void saveEditAccount(){
		
		String name = this.name;
		
		String lastName = this.lastName;
		
		String password = this.password;
		
		String login = this.login;
		
		String email = this.email;
		
		String confirmatePassword = this.confirmatePassword;
		
		if(login == null){
			this.login = this.editLogin;
		}
		
		if(password.equals(confirmatePassword)){
			
			if(userRepositoryBean.putLogin(login)==null){
				
				userService.saveEditAccount(name, lastName, login, email, password);
			
			}
			
		}
		
		
	}

	public void newAccount(){
		
		String name = this.name;
		
		String lastName = this.lastName;
		
		String password = this.password;
				
		String email = this.email;
		
		String confirmatePassword = this.confirmatePassword;
		
		this.login = this.newLogin;
		
		if(password.equals(confirmatePassword)){
		
			if(userRepositoryBean.putLogin(login)==null){
				
				userService.createNewAccount(name, lastName, login, email, password);
			
			}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "User already exists", "Change Login");
			    FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
		}else{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirmate Password Error !", "Password Error");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getNewLogin() {
		return newLogin;
	}

	public void setNewLogin(String newLogin) {
		this.newLogin = newLogin;
	}

	public User getUser() {
		return user;
	}

	public String getConfirmatePassword() {
		return confirmatePassword;
	}

	public void setConfirmatePassword(String confirmatePassword) {
		this.confirmatePassword = confirmatePassword;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditLogin() {
		return editLogin;
	}

	public void setEditLogin(String editLogin) {
		this.editLogin = editLogin;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}