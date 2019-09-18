package com.wp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Laptop;
import com.wp.model.Vehicle;
import com.wp.utility.DataConnect;

public class UpdateVehicleData {
	public static void updateVehicleData() {
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("============================Select the vehicle from list you want to update==============================");
		SQLQuery query1 = session.createSQLQuery("select * from vehicle");
		List<Object[]> list1 = query1.list();
		
		System.out.println("-----------------------------------------Vehicle List-----------------------------------------------");
		for(int i=0; i<list1.size();i++) {
				System.out.println("		ID :- "+list1.get(i)[0]+"  Brand :- "+list1.get(i)[1]+"  Price :- "+list1.get(i)[2]);		
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Welcome To Vehicle Data Update Platform");
		System.out.println("1. Update Brand");
		System.out.println("2. Update Price");
		System.out.println("Please select one from above given choices");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Vehicle Id");
		String id = sc.nextLine();
		Vehicle v = session.get(Vehicle.class,id);
		switch (choice) {
		case 1:
			System.out.print("Enter new brand name :-> ");
			String brand = sc.nextLine();
			v.setBrand(brand);
			session.update(v);
			tr.commit();
			System.out.println("Updated successfully");
			break;
		case 2:
			System.out.println("Enter new price :-> ");
			int price = sc.nextInt();
			v.setPrice(price);
			session.update(v);
			tr.commit();
			System.out.println("Updated successfully");
			break;

		default:
			System.out.println("Bye-Bye");
			break;
		}
		session.close();
		sc.close();
	}
}
