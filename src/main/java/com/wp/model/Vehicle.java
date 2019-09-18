package com.wp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	
	@Id
	private String vehicle_id;
	private String brand;
	private int price;
	
	@OneToMany(mappedBy="vehicle", cascade = CascadeType.ALL)
	private List<Employee> employeelist;

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", brand=" + brand + ", price=" + price + "]";
	}

	public Vehicle(String vehicle_id, String brand, int price) {
		super();
		this.vehicle_id = vehicle_id;
		this.brand = brand;
		this.price = price;
	}

	public Vehicle() {
		super();
	}
}
