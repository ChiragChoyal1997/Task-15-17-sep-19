package com.wp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Project;
import com.wp.utility.DataConnect;

public class UpdateProjectData {
	public static void updateProjectData() {
		Session session = DataConnect.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("============================Select the Project from list you want to update==============================");
		SQLQuery query = session.createSQLQuery("select pno, pname from project");
		List<Object[]> list = query.list();
		System.out.println("--------------------------------------------Project List-------------------------------------------");
		for(int x=0; x<list.size();x++) {
			System.out.println("		Id :- "+list.get(x)[0]+"  Project Name :- "+list.get(x)[1]);
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Welcome To Laptop Data Update Platform");
		System.out.println("1. Update Project Name");
		System.out.println("2. Exit");
		System.out.println("Please select one from above given choices");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Project Id");
		String id = sc.nextLine();
		Project p = session.get(Project.class,id);
		switch (choice) {
		case 1:
			System.out.print("Enter new name of project :-> ");
			String pname = sc.nextLine();
			p.setPname(pname);;
			session.update(p);
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
