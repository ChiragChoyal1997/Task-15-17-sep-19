package com.wp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private String pno;
	private String pname;
	
	@ManyToMany(mappedBy = "projectlist")
	private List<Employee> employeelist;

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public Project(String pno, String pname) {
		super();
		this.pno = pno;
		this.pname = pname;
		
	}

	public Project() {
		super();
	}

	@Override
	public String toString() {
		return "Project [pno=" + pno + ", pname=" + pname + ", employeelist=" + employeelist + "]";
	}
	
	
}
