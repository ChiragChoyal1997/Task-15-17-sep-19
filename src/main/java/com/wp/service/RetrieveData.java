package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Project;
import com.wp.model.Vehicle;
import com.wp.utility.DataConnect;

public class RetrieveData {
	public static void retrieveData() {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Search record of.....");
		System.out.println("1. Employee");
		System.out.println("2. Vehicle");
		System.out.println("3. Laptop");
		System.out.println("4. Project");
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.println("Enter Employee Id");
			int eno = sc.nextInt();
			sc.nextLine();
			Employee e = session.get(Employee.class, eno);
			if(e != null) {
				System.out.println(e.toString());
			}
			else {
				System.out.println("Employee record not found!");
			}
			tr.commit();
			session.close();
			break;
		case 2:
			System.out.println("Enter laptop Id");
			String lid = sc.nextLine();
			Laptop l = session.get(Laptop.class, lid);
			if(l != null) {
				System.out.println(l.toString());
			}
			else {
				System.out.println("Laptop record not found!");
			}
			tr.commit();
			session.close();
			break;
		case 3:
			System.out.println("Enter vehicle Id");
			String vid = sc.nextLine();
			Vehicle v = session.get(Vehicle.class, vid);
			if(v != null) {
				System.out.println(v.toString());
			}
			else {
				System.out.println("Vehicle record not found!");
			}
			tr.commit();
			session.close();
			break;
		case 4:
			System.out.println("Enter project code");
			String pid = sc.nextLine();
			Project p = session.get(Project.class, pid);
			if(p != null) {
				System.out.println(p.toString());
			}
			else {
				System.out.println("Project record not found!");
			}
			tr.commit();
			session.close();
		default:
			System.out.println("Bye-Bye");
			break;
		}
		sc.close();
	}
}
