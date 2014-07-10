package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ @NamedQuery(name = "owner.all", query = "Select o from Owner o"),
		@NamedQuery(name = "owner.some", query = "Select o from Owner o where o.name = :name") })
public class Owner {
	private Long id;
	private String name;
	private String surname;
	private int usuniecie = 0;

	public Owner() {
	}

	public Owner(long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
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
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUsuniecie() {
		return usuniecie;
	}

	public void setUsuniecie(int usuniecie) {
		this.usuniecie = usuniecie;
	}
}