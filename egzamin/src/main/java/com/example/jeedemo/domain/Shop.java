package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ @NamedQuery(name = "shop.all", query = "Select s from Shop s"),
		@NamedQuery(name = "shop.some", query = "Select s from Shop s where s.town = :town"),
		@NamedQuery(name = "shop.name", query = "Select s from Shop s where s.name = :name") })
public class Shop {
	private Long id;
	private String name;
	private String town;
	private String street;
	private Owner owner;
	int usuniecie = 0;

	public Shop() {
	}

	public Shop(Long id, String name, String town, String street) {
		super();
		this.id = id;
		this.name = name;
		this.town = town;
		this.street = street;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 2, max = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(min = 2, max = 20)
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Size(min = 2, max = 20)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@OneToOne
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getUsuniecie() {
		return usuniecie;
	}

	public void setUsuniecie(int usuniecie) {
		this.usuniecie = usuniecie;
	}
}