package org.serratec.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size (min = 2,max = 40)
	private String name;

	@NotNull
	@Size (min = 11,max = 14)
	private String cpf;
	
	@NotNull
	@Size (min = 6,max = 20)
	private String password;
	
	
	public Employee() {
		super();
	}

	public Employee(@Valid Integer id,String name,String cpf,String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
