package com.wp.service;

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

public class UpdateEmployeeData {
	public static void updateEmployeeData() {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();
		System.out.println("Enter Employee Id to update data");
		int eno = sc.nextInt();
		sc.nextLine();
		Employee e = session.get(Employee.class, eno);
		int exit = 0;
		while(exit == 0) {
			System.out.println("Update Employee details");
			System.out.println("1. Employee name");
			System.out.println("2. Employee salary");
			System.out.println("3. Update Laptop Id");
			System.out.println("4. Update Vehicle Id");
			System.out.println("5. Update Projects Id");
			System.out.println("6. Exit");
			System.out.println("your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			Transaction tr = session.beginTransaction();
			switch (choice) {
			case 1:
				System.out.println("Enter new ename");
				String ename = sc.nextLine();
				e.setEname(ename);
				session.update(e);
				tr.commit();
				System.out.println("Employee record updated");
				break;
			case 2:
				System.out.println("Enter new salary");
				int sal = sc.nextInt();
				e.setSal(sal);
				session.update(e);
				tr.commit();
				System.out.println("Employee record updated");
				break;
			case 3:
				System.out.println("===================================Laptops available in Inventory=================================");
				SQLQuery query = session.createSQLQuery("select code,brand from laptop where code not in (select unique(e.laptop_code) from laptop l, employee e where l.code != e.laptop_code)");
				List<Object[]> list = query.list();
				System.out.println("--------------------------------------------Laptop List-------------------------------------------");
				for(int x=0; x<list.size();x++) {
					System.out.println("*		Laptop code :- "+list.get(x)[0]+"	Laptop Brand :- "+list.get(x)[1]);
				}
				System.out.println("-------------------------------------------------------------------------------------------------------");
				System.out.println("Pick one from list and Enter laptop id");
				String newlid = sc.nextLine();
				Laptop l = session.get(Laptop.class, newlid);
				e.setLaptop(l);
				session.update(e);
				tr.commit();
				System.out.println("Employee record updated");
				break;
			case 4:
				SQLQuery query1 = session.createSQLQuery("select * from vehicle where lower(vehicle_id) != lower('"+e.getVehicle().getVehicle_id()+"')");
				List<Object[]> list1 = query1.list();
				
				System.out.println("-----------------------------------------Vehicle List-----------------------------------------------");
				for(int i=0; i<list1.size();i++) {
						System.out.println("*		Vehicle code :- "+list1.get(i)[0]+"		Vehicle Brand :- "+list1.get(i)[1]);		
				}
				System.out.println("-------------------------------------------------------------------------------------------------------");
				System.out.println("Enter new vehicle id");
				String newvid = sc.nextLine();
				Vehicle v = session.get(Vehicle.class, newvid);
				e.setVehicle(v);
				session.update(e);
				tr.commit();
				System.out.println("Employee record updated");
				break;
			case 5:
				System.out.println("This are the projects that are assigned to employee");
				Set<Project> projectset = e.getProjectlist();
				System.out.println("-------------------------------------------------------------------------------------");
				for(Project p:projectset) {
					System.out.println("	Project Code :-> "+p.getPno()+"		Project Name :-> "+p.getPname());
				}
				System.out.println("-------------------------------------------------------------------------------------");

				int loop = 1;
				while(loop == 1) {
					System.out.println("Do you want to?");
					System.out.println("1. Assign some more projects");
					System.out.println("2. Takeover some projects from employee");
					System.out.println("3. Exit");
					System.out.print("Enter your choice -> ");
					int choice2  = sc.nextInt();
					sc.nextLine();
					switch (choice2) {
					case 1:
						System.out.println("Enter the project id you want to assign to employee");
						String pcode = sc.nextLine();
						Project p = session.get(Project.class, pcode);
						projectset.add(p);
						e.setProjectlist(projectset);
						session.update(e);
						tr.commit();
						System.out.println("Project assigned to employee");
						break;
					case 2:
						System.out.println("Enter the project id you want to takeover from employee");
						String pid = sc.nextLine();
						Project p1 = session.get(Project.class, pid);
						projectset.remove(p1);
						e.setProjectlist(projectset);
						session.update(e);
						tr.commit();
						System.out.println("Project taken from employee");
						break;
					default:
						loop = 0;
						System.out.println("Bye-Bye");
						break;
					}
				}
				System.out.println("Employee record updated");
				break;
			default:
				exit = 1;
				System.out.println("Bye-Bye");
				break;
			}
			tr.commit();
		}
		session.close();
		sc.close();
	}
}
