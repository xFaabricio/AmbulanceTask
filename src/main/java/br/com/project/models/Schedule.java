package br.com.project.models;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.mapping.Selectable;

import br.com.project.schedule.Gender;
import br.com.project.schedule.MaritalStatus;
import br.com.project.schedule.Status;


@Entity
@Table(name="schedule")
@Named
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Schedule.findAll", query = "SELECT sch FROM Schedule sch"),
  	@NamedQuery(name = "Schedule.findByScheduleId", query = "SELECT sch FROM Schedule sch WHERE sch.id = :id")
    })
public class Schedule extends BaseEntity implements Selectable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Short id;
	
	@Column(name="NAME", length=4000)
	@NotNull
	private String name;
	
	@Column(name="BIRTH_DATE")
	@NotNull
	private Date birthDate;
	
	@Column(name="RG", length=20)
	@NotNull
	private String rg;
	
	@Column(name="CPF", length=25)
	@NotNull
	private String cpf;
	
	@Column(name="MARITAL_STATUS")
	@NotNull
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	
	@Column(name="NATIONALITY", length=1000)
	@NotNull
	private String nationality;
	
	@Column(name="GENDER")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="ADDRESS", length=4000)
	@NotNull
	private String address;

	@Column(name="NUMBER", length=1000)
	@NotNull
	private String number;
	
	@Column(name="NEIGHBORHOOD", length=2000)
	@NotNull
	private String neighborhood;
	
	@Column(name="CITY", length=2000)
	@NotNull
	private String CITY;
	
	@Column(name="CEP", length=20)
	@NotNull
	private String CEP;
	
	@Column(name="STATUS")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getbirthDate() {
		return birthDate;
	}

	public void birthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getCEP() {
		return CEP;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getAlias(Dialect arg0) {
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

	@Override
	public String getAlias(Dialect arg0, org.hibernate.mapping.Table arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
