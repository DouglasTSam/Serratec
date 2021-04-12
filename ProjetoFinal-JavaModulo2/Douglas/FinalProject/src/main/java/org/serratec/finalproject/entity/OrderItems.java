package org.serratec.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "product_ID")
	private Products product;
	
	public OrderItems() {
		super();
	}

	public OrderItems(Integer id,Integer quantity,double price,Products product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
//		this.order = order;
	}
	
	public Double getSubTotal() {
		return quantity*price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	/*public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}*/
	
}
