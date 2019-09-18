package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Laptop;
import com.wp.utility.DataConnect;

public class AddLaptop {
	
	public static void addLaptop() {
		
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		//code for storing data of assigned laptop to employee
		System.out.println("Add laptop id that is to be assigned to employee");
		System.out.println("Enter laptop id");
		String lpid = sc.nextLine();
		System.out.println("Enter laptop brand");
		String lbrand = sc.nextLine();
		System.out.println("Enter laptop price");
		int lprice = sc.nextInt();
		sc.nextLine();
		
		Laptop l = new Laptop(lpid, lbrand, lprice);
		session.save(l);
		tr.commit();
		session.close();
		sc.close();
	}

}
