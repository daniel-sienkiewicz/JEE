package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.servletjspdemo.web.CarFormBean;

public class StorageService {

	private List<CarFormBean> db = new ArrayList<CarFormBean>();

	public void add(CarFormBean car) {
		CarFormBean newCar = new CarFormBean(car.getMake(), car.getModel(), car.getYop(), car.getType(), car.getCapacity(), car.getEquipment(), car.getInfo());
		db.add(newCar);
	}

	public List<CarFormBean> getAllCars() {
		return db;
	}
}