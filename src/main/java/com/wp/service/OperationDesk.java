package com.wp.service;

import java.util.Scanner;

public class OperationDesk {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while(i==1) {
		
		System.out.println("Welcome to DashBoard");
		System.out.println("1. Add Laptop");
		System.out.println("2. Add Vehicle");
		System.out.println("3. Add Project");
		System.out.println("4. Add Employee");
		System.out.println("5. Update Laptop Details");
		System.out.println("6. Update Vehicle Details");
		System.out.println("7. Update Project Details");
		System.out.println("8. Update Employee Details");
		System.out.println("9. Delete Operation On All Entities");
		System.out.println("10. Search By Id Operation On All Entities");
		System.out.println("11. Exit");
		
		System.out.println("Select One of the above Operation");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1:
			AddLaptop.addLaptop();
			break;
		case 2:
			AddVehicle.addVehicle();
				break;
		case 3:
			AddProject.addProject();
			break;
		case 4:
			AddEmployee.addEmployee();
			break;
		case 5:
			UpdateLaptopData.updateLaptopData();
			break;
		case 6:
			UpdateVehicleData.updateVehicleData();
			break;
		case 7:
			UpdateProjectData.updateProjectData();
			break;
		case 8:
			UpdateEmployeeData.updateEmployeeData();
			break;
		case 9:
			DeleteData.deleteData();
			break;
		case 10:
			RetrieveData.retrieveData();
			break;
		default:
			sc.close();
			System.out.println("Bye - Bye");
			break;
		}
		}
	}

}
