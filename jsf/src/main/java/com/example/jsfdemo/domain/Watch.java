package com.example.jsfdemo.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Watch {
	private String model;
	private String producer;
	private double price;
	private String serialNumber;
	private int strapLength;
	private Date dop = new Date();
	
	public Watch(String model, String producer, double price, String serialNumber, int strapLength, Date dop) {
		super();
		this.model = model;
		this.producer = producer;
		this.price = price;
		this.serialNumber = serialNumber;
		this.strapLength = strapLength;
		this.dop = dop;
	}

	public Watch() {
	}

	@Pattern(regexp = "[A-Z]{4}-[0-9]{3}")
	public String getModel() {
		return model;
	}

	@Past
	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Size(min = 2, max = 20)
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
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

	@Min(0)
	public int getStrapLength() {
		return strapLength;
	}

	public void setStrapLength(int strapLength) {
		this.strapLength = strapLength;
	}
}