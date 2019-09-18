package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Vehicle;
import com.wp.utility.DataConnect;

public class AddVehicle {

	public static void addVehicle() {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		//code for storing data of assigned vehicle to employee
		System.out.println("Add vehicle to employee");
		System.out.println("Enter vehicle id");
		String vid = sc.nextLine();
		System.out.println("Enter brand of vehicle");
		String vbrand = sc.nextLine();
		System.out.println("Enter vehicle price");
		int vprice = sc.nextInt();
		sc.nextLine();
		
		Vehicle v = new Vehicle(vid, vbrand, vprice);
		session.save(v);
		tr.commit();
		session.close();
		sc.close();
		System.out.println("Vehicle added successfully");
	}
}
