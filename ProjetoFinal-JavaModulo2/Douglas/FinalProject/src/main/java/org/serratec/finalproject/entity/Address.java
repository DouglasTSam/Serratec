package org.serratec.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size (min = 2,max = 40)
	private String street;
	
	@Size (max = 10)
	private String number;
	

	@Size (max = 40)
	private String complement;
	
	@NotNull
	@Size (min = 1,max = 20)
	private String neighborhood;
	
	@NotNull
	@Size (min = 2,max = 10)
	private String postalCode;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String city;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String state;


	public Address() {
		super();
	}


	public Address(@Valid Integer id,String street,String number,String complement,String neighborhood,String postalCode,String city,String state) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
}
