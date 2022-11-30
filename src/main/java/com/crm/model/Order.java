package com.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type_presta")
	private String typePresta;
	@Column(name = "designation")
	private String designation;
	@Column(name = "nb_days")
	private String nbDays;
	@Column(name = "unit_price")
	private String unitPrice;
	@Column(name = "state")
	private OrderState state;

	@ManyToOne
	private Client client;

	public Order() {

	}

	public Order(String typePresta, String designation, String nbDays, String unitPrice, OrderState state, Client client) {

		this.typePresta = typePresta;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getNbDays() {
		return nbDays;
	}

	public void setNbDays(String nbDays) {
		this.nbDays = nbDays;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", typePresta=" + typePresta + ", designation=" + designation + ", nbDays=" + nbDays
				+ ", unitPrice=" + unitPrice + ", state=" + state.name() + ", client=" + client + "]";
	}

}
