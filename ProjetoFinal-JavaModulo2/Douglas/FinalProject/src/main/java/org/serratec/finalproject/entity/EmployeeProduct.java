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
public class EmployeeProduct {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String action;
	
	@NotNull
	private Date dateAction;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "address_ID")
	private Address address;

	public EmployeeProduct() {
		super();
	}

	public EmployeeProduct(@Valid Integer id, String action, Date dateAction) {
		super();
		this.id = id;
		this.action = action;
		this.dateAction = dateAction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
}
