package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.model.Project;
import com.wp.utility.DataConnect;

public class AddProject {

	public static void addProject() {
			
			Scanner sc = new Scanner(System.in);
			Session session = DataConnect.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			//code for storing data of assigned projects to employee
			System.out.println("Add Project to database");
			System.out.println("Enter Project Number/Code");
			String pid = sc.nextLine();
			System.out.println("Enter Project Name");
			String pname = sc.nextLine();
			
			Project p = new Project(pid, pname);
			session.save(p);
			tr.commit();
			session.close();
			sc.close();
			System.out.println("Project added successfully!");
	}
}
