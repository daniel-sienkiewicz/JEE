package com.example.servletjspdemo.web;

public class CarFormBean {
	private String make; //model
	private String model; //marka
	private int yop; //rok produkcji
	private String type; //typ nadwozia
	private String[] capacity; //pojemność silnika
	private String[] equipment; //multiple choise
	private String info;
	
	public enum TypeEnum {
		SEDAN ("Sedan"),
		COMBI ("Combi"),
		HATCHBACK ("Hatchback"),
		KABRIOLET ("Kabriolet"),
		VAN("Van");
		
		private final String opis;
		TypeEnum(String opis) {
			this.opis = opis;
	    }
		
		public String toString() { 
			 return opis;
		}
	}

	public enum CapacityEnum {
		ONE ("1.0"),
		TWOO ("1.8"),
		TREE ("2.0"),
		FOUR ("2.5");
		
		private final String opis;
		CapacityEnum(String opis) {
			this.opis = opis;
	    }
		
		public String toString() { 
			 return opis;
		}
	}
	
	public enum EquipmentEnum {
		LIGHTS ("Lights"),
		MIRRORS ("Mirrors"),
		WHEELS ("Wheels"),
		KEYS ("Keys"),
		RADIO("Radio");
		
		private final String opis;
		EquipmentEnum(String opis) {
			this.opis = opis;
	    }
		
		public String toString() { 
			 return opis;
		}
	}
	
	public CarFormBean() {
	}

	public CarFormBean(String make, String model, int yop, String type, String[] capacity, String[] equipment, String info) {
		super();
		this.make = make;
		this.model = model;
		this.yop = yop;
		this.type = type;
		this.capacity = capacity;
		this.equipment = equipment;
		this.info = info;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYop() {
		return yop;
	}
	
	public String[] getCapacity() {
		return capacity;
	}

	public String getType() {
		return type;
	}
		
	public String[] getEquipment() {
		return equipment;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setCapacity(String[] capacity) {
		this.capacity = capacity;
	}
	
	public void setEquipment(String[] equipment) {
		
		this.equipment = equipment;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getEquipmentToString() {
		String equ = "";
		for(int i = 0; i < equipment.length; i++)
			equ = equ + " " + equipment[i];
		return equ;
	}
	
	public String getCapacityToString() {
		String cap = "";
		for(int i = 0; i < capacity.length; i++)
			cap = cap + " " + capacity[i];
		return cap;
	}
}
