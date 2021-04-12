package org.serratec.finalproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size (min = 2,max = 40)
	private String nameComplet;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String email;
	
	@NotNull
	@Size (min = 11,max = 14)
	private String cpf;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String userName;
	
	@NotNull
	private Date dateOfBirth;
	
	@NotNull
	@Size (min = 6,max = 20)
	private String password;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "address_ID")
	private Address address;
	
	
	public Customers() {
		super();
	}

	public Customers(@Valid Integer id, String nameComplet, String email, String cpf, String userName,Date dateOfBirth,String password,Address address) {
		super();
		this.id = id;
		this.nameComplet = nameComplet;
		this.email = email;
		this.cpf = cpf;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameComplet() {
		return nameComplet;
	}

	public void setNameComplet(String nameComplet) {
		this.nameComplet = nameComplet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
		
}
