package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Project;
import com.wp.model.Vehicle;
import com.wp.utility.DataConnect;

public class DeleteData {
	public static void deleteData() {

		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();

		Transaction tr = session.beginTransaction();
		System.out.println("Which record you want to delete");
		System.out.println("1. Employee");
		System.out.println("2. Laptop");
		System.out.println("3. Vehicle");
		System.out.println("4. Project");
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		sc.nextLine();
		Boolean found = false;
		switch (choice) {
		case 1:
			System.out.println("Enter employee id");
			int eno = sc.nextInt();
			sc.nextLine();
			Employee e = session.get(Employee.class, eno);
			if(e != null) {
				found = true;
			}
			if(found) {
				session.delete(e);
				tr.commit();
				System.out.println("Data deleted successfully !");
			}
			else {
				System.out.println("Record not found !");
			}
			session.close();
			break;
		case 2:
			System.out.println("Enter laptop id");
			String lno = sc.nextLine();
			Laptop l = session.get(Laptop.class, lno);
			if(l != null) {
				found = true;
			}
			if(found) {
				session.delete(l);
				tr.commit();
				System.out.println("Data deleted successfully !");
			}
			else {
				System.out.println("Record not found !");
			}
			session.close();
			break;
		case 3:
			System.out.println("Enter vehicle id");
			String  vno = sc.nextLine();
			Vehicle v = session.get(Vehicle.class, vno);
			if(v != null) {
				found = true;
			}
			if(found) {
				session.delete(v);
				tr.commit();
				System.out.println("Data deleted successfully !");
			}
			else {
				System.out.println("Record not found !");
			}
			session.close();			

			break;
		case 4:
			System.out.println("Enter Project id");
			String pno = sc.nextLine();
			Project p = session.get(Project.class, pno);
			if(p != null) {
				found = true;
			}
			if(found) {
				session.delete(p);
				tr.commit();
				System.out.println("Data deleted successfully !");
			}
			else {
				System.out.println("Record not found !");	
			}
			session.close();

			break;
		default :
			session.close();
			System.out.println("Bye-Bye");
			break;
		}
		sc.close();
	}
}
