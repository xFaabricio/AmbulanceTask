package br.com.project.authenticate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.project.models.User;
 
@ManagedBean
public class CaptchaView {
 
	@Inject
	Password password;
	
	@Inject
	User user;
	
    public void submit() {
		    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Logged User");
		    FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
}