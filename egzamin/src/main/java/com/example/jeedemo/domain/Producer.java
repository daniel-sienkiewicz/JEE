package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "producer.all", query = "Select p from Producer p"),
	@NamedQuery(name = "producer.some", query = "Select p from Producer p where p.town = :town"),
	@NamedQuery(name = "producer.name", query = "Select p from Producer p where p.name = :name")
})
public class Producer {
	private Long id;
	private String name;
	private String town;
	private int usuniecie = 0;

	public Producer() {
	}

	public Producer(Long id, String name, String town) {
		super();
		this.id = id;
		this.name = name;
		this.town = town;
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

	public int getUsuniecie() {
		return usuniecie;
	}

	public void setUsuniecie(int usuniecie) {
		this.usuniecie = usuniecie;
	}
}