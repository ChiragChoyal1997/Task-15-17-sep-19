package com.wp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	private int eno;
	private String ename;
	private int sal;
	
	@OneToOne
	private Laptop laptop;
	
	@ManyToOne
	private Vehicle vehicle;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Project> projectlist;

	public Employee(int eno, String ename, int sal, Laptop laptop, Vehicle vehicle) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.laptop = laptop;
		this.vehicle = vehicle;
	}

	public Employee() {
		super();
	}

    public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Set<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(Set<Project> projectlist) {
		this.projectlist = projectlist;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", laptop=" + laptop + ", vehicle="
				+ vehicle + "]";
	}
}
