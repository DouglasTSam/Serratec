package org.serratec.finalproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Date dateOrder;
	
	@ManyToOne
	@JoinColumn(name = "customer_ID")
	private Customers customer;
	
	@OneToMany(targetEntity = OrderItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Order_ID")
	private List<OrderItems>items = new ArrayList<>();	

	public Orders() {
		super();
	}

	public Orders(Integer id,Date dateOrder,Customers customer) {
		super();
		this.id = id;
		this.dateOrder = dateOrder;
		this.customer = customer;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrderItems item : items) {
			total = total + item.getSubTotal();
		}
		return total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}	
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public List<OrderItems> getItems() {
		return items;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}
	
}
