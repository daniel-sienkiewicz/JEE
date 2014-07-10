package com.example.jeedemo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "watch.all", query = "Select w from Watch w"),
	@NamedQuery(name = "watch.some", query = "Select w from Watch w where w.price = :price AND w.strapLength > :strapLength"),
	@NamedQuery(name = "watch.up", query = "Select w from Watch w where w.serialNumber = :serialNumber")
})
public class Watch {
	private Long id;
	private String model;
	private double price;
	private String serialNumber;
	private int strapLength;
	private Producer make;
	private List<Shop> shops;

	public Watch() {
	}

	public Watch(Long id, String model, double price, String serialNumber, int strapLength) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.serialNumber = serialNumber;
		this.strapLength = strapLength;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Pattern(regexp = "[A-Z]{4}-[0-9]{3}")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getStrapLength() {
		return strapLength;
	}

	public void setStrapLength(int strapLength) {
		this.strapLength = strapLength;
	}
	
    @ManyToOne
    public Producer getProducer() {
            return make;
    }
    public void setProducer(Producer producer) {
            this.make = producer;
    }
    
	@ManyToMany
	public List<Shop> getShop() {
		return shops;
	}

	public void setShop(List<Shop> shop) {
		this.shops = shop;
	}
}