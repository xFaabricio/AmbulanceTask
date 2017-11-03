package br.com.project.user;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.mapping.Selectable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.project.models.BaseEntity;

@Entity
@Table(name="user_system")
@Named
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT usr FROM User usr"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT usr FROM User usr WHERE usr.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT usr FROM User usr WHERE usr.name = :name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT usr FROM User usr WHERE usr.email = :email"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT usr FROM User usr WHERE usr.login = :login")})
public class User extends BaseEntity implements Selectable, UserDetails, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Short id;
	
	@Column(name="LOGIN", length=512)
	@NotNull
	private String login;
	
	@Column(name="EMAIL", length=4000)
	@NotNull
	private String email;
	
	@Column(name="PASSWORD", length=4000)
	@NotNull
	private String password;
	
	@Column(name="NAME", length=4000)
	@NotNull
	private String name;
	
	@Column(name="LAST_NAME", length=4000)
	private String lastName;
	
	
	@ManyToOne(targetEntity = Group.class, cascade = CascadeType.ALL)
	@JoinTable(name="USER_GROUP",joinColumns= 
	@JoinColumn(name="USER_ID", referencedColumnName="ID"),	
	inverseJoinColumns= 
	@JoinColumn(name="GRUPO_ID", referencedColumnName="ID"))
	private Group group;


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

//	public List<User> getUsersSelecteds() {
//		return usersSelecteds;
//	}
//
//	public void setUsersSelecteds(List<User> usersSelecteds) {
//		this.usersSelecteds = usersSelecteds;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User(Short id, String login, String email, String password, String name, String lastName,
			Group group) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.group = group;
	}

	public User(String login, String email, String name) {
		super();
		this.login = login;
		this.email = email;
		this.name = name;
	}
	
	
//	public List<User> getUsers(){
//		return userRepositoryBean.usuarios();
//	}
	
	public User() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAlias(Dialect arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlias(Dialect arg0, org.hibernate.mapping.Table arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTemplate(Dialect arg0, SQLFunctionRegistry arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Dialect arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFormula() {
		// TODO Auto-generated method stub
		return false;
	}

}
