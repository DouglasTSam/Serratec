package org.serratec.finalproject.entity;

import java.util.Date;

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
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size (min = 2,max = 40)
	private String name;

	@NotNull
	@Size (min = 1,max = 200)
	private String description;

	@NotNull
	private Date dateFabrication;

	@NotNull
	private double princeUnity;

	@NotNull
	private double inSstock;
	
	 @ManyToOne
	 @JoinColumn(name = "employee_id", referencedColumnName = "id")
	 private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "category_ID")
	private Category category;

	public Products(Integer id,String name, String description,Date dateFabrication,double princeUnity, double inSstock,Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateFabrication = dateFabrication;
		this.princeUnity = princeUnity;
		this.inSstock = inSstock;
		this.category = category;
	}

	public Products() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public double getPrinceUnity() {
		return princeUnity;
	}

	public void setPrinceUnity(double princeUnity) {
		this.princeUnity = princeUnity;
	}

	public double getInSstock() {
		return inSstock;
	}

	public void setInSstock(double inSstock) {
		this.inSstock = inSstock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
