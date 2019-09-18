package com.wp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Laptop;
import com.wp.utility.DataConnect;

public class UpdateLaptopData {
	public static void updateLaptopData() {
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("============================Select the laptop from list you want to update==============================");
		SQLQuery query = session.createSQLQuery("select code, brand, price from laptop");
		List<Object[]> list = query.list();
		System.out.println("--------------------------------------------Laptop List-------------------------------------------");
		for(int x=0; x<list.size();x++) {
			System.out.println("		Id :- "+list.get(x)[0]+"  Brand :- "+list.get(x)[1]+"  price :-"+list.get(x)[2]);
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Welcome To Laptop Data Update Platform");
		System.out.println("1. Update Brand");
		System.out.println("2. Update Price");
		System.out.println("Please select one from above given choices");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Laptop Id");
		String id = sc.nextLine();
		Laptop l = session.get(Laptop.class,id);
		switch (choice) {
		case 1:
			System.out.print("Enter new brand name :-> ");
			String brand = sc.nextLine();
			l.setBrand(brand);
			session.update(l);
			tr.commit();
			System.out.println("Updated successfully");
			break;
		case 2:
			System.out.println("Enter new price :-> ");
			int price = sc.nextInt();
			l.setPrice(price);
			session.update(l);
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
