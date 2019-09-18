package com.wp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Project;
import com.wp.model.Vehicle;
import com.wp.utility.DataConnect;

public class AddEmployee {
	public static void addEmployee() {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		
		//code for storing employee data
		System.out.println("===========================Add Employee Data============================");
		System.out.println("Enter employee id");
		int eno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name");
		String ename = sc.nextLine();
		System.out.println("Enter employee salary");
		int sal = sc.nextInt();
		sc.nextLine();
		
		
		///Code for suggesting the laptop that are available and can be assigned to new employee
		System.out.println("============================Enter laptop details that is to be assigned==============================");
		SQLQuery query = session.createSQLQuery("select code,brand from laptop where code not in (select unique(e.laptop_code) from laptop l, employee e where l.code != e.laptop_code)");
		List<Object[]> list = query.list();
		System.out.println("--------------------------------------------Laptop List-------------------------------------------");
		for(int x=0; x<list.size();x++) {
			System.out.println("*		Laptop code :- "+list.get(x)[0]+" Laptop Brand :- "+list.get(x)[1]);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Enter code of laptop");
		String lcode = sc.nextLine();
		Laptop l = session.get(Laptop.class, lcode);
		
		
		///Code for suggesting the vehicle(pick and drop facility) that are available and can adjust employee in that vehicle. 
		System.out.println("============================Enter vehicle details that is to be assigned==============================");
		SQLQuery query1 = session.createSQLQuery("select * from vehicle");
		List<Object[]> list1 = query1.list();
		
		System.out.println("-----------------------------------------Vehicle List-----------------------------------------------");
		for(int i=0; i<list1.size();i++) {
				System.out.println("*		Vehicle code :- "+list1.get(i)[0]+" Vehicle Brand :- "+list1.get(i)[1]);		
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Enter code of vehicle");
		String vcode = sc.nextLine();
		Vehicle v = session.get(Vehicle.class, vcode);
		
		
		/// code for showing the projects that are running in the company and admin can assign multiple projects to employee.
		System.out.println("============================Enter Project details that is to be assigned==============================");
		Set<Project> pset = new HashSet();//since a employee can have multiple projects so we took set.
		SQLQuery query2 = session.createSQLQuery("select pno, pname from project");
		List<Object[]> projectlist = query2.list();
		
		System.out.println("-------------------------------------Projects List--------------------------------------");
		for(int x=0 ; x<projectlist.size();x++) {
			System.out.println("*		Project code :- "+projectlist.get(x)[0]+" Project Name :- "+projectlist.get(x)[1]);
		}
		
		int choice = 1;
		while(choice == 1) {
		System.out.println("***********************************");
		System.out.println("		1. Add Projects		");
		System.out.println("		0. Exit				");
		System.out.println("***********************************");
		System.out.println("Wanna assign some projects");
		int addProject = sc.nextInt();
		sc.nextLine();
		switch (addProject) {
		case 1:
			System.out.println("Enter project code from the above project list");
			String pcode = sc.nextLine();
			Project p = session.get(Project.class, pcode);
			pset.add(p);
			break;
		case 0:
			choice = 0;
			break;

		default:
			break;
		}
		}
		
		Employee e = new Employee(eno, ename, sal, l, v);
		if(pset.size() == 0) {
			pset = null;
		}
		e.setProjectlist(pset);
		session.save(e);
		tr.commit();
		session.close();
		sc.close();
		System.out.println("Employee Data added succefully !");
	}
}
