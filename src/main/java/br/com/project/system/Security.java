package br.com.project.system;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Security {

//	@Inject
//	private ExternalContext externalContext;
	
//	byte[] profilePicture;
	
//	public byte[] getProfilePicture(){
//		
//		UserSystem userSystem = getLoggedUser();
//		User user = userSystem.getUser();
//		
//		return null;
//	}
	
	
	public String getNameAndLastNameUser() {
		String name = null;
		
		UserSystem usuarioLogado = getLoggedUser();
		
		if (usuarioLogado != null) {
			name = usuarioLogado.getUser().getName() + " " + usuarioLogado.getUser().getLastName();
		}
		
		return name;
	}
	
	public String getNameUser() {
		String name = null;
		
		UserSystem usuarioLogado = getLoggedUser();
		
		if (usuarioLogado != null) {
			name = usuarioLogado.getUser().getName();
		}
		
		return name;
	}
	
	public String getLoginUser(){
		String login = null;
		
		UserSystem usuarioLogado = getLoggedUser();
		
		if (usuarioLogado != null) {
			login = usuarioLogado.getUser().getLogin();
		}
		
		return login;
	}
		
	@Produces
	@UserLogged
	public UserSystem getLoggedUser() {
		UserSystem user = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			user = (UserSystem) auth.getPrincipal();
		}
		
		return user;
	}
	
}
