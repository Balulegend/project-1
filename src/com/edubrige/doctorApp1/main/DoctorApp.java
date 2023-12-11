package com.edubrige.doctorApp1.main;

import java.util.List;
import java.util.Scanner;

import com.edubrige.doctorApp1.dao.DoctorDao;
import com.edubrige.doctorApp1.dao.DoctorDaoImpl;
import com.edubrige.doctorApp1.model.Doctor;
import com.edubrige.doctorApp1.service.DoctorService;
import com.edubrige.doctorApp1.service.DoctorServiceImpl;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class DoctorApp {
	public static void main(String[] args) {
		DoctorDao dao = new DoctorDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		String Id= null,name = null, designation = null;
		double fees =0;
		
		
		do {
			System.out.println("Doctor Application");
			System.out.println("1.Add Doctor");
			System.out.println("2.Display All Doctors");
			System.out.println("3.Update Doctor");
			System.out.println("4.Delete Doctor By Name");
			System.out.println("5.Search Doctor By Name");
			System.out.println("6.Delete All Doctors");
			System.out.println("0.Exit");
			System.out.println("please select one option: ");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("ADD");
				
				System.out.println("please enter doctor id");
				Id = sc.next();
				
				System.out.println("please enter doctor name");
				name = sc.next();
				
				System.out.println("please enter doctor designation");
				designation= sc.next();
				
				System.out.println("please enter doctor fees");
				fees = sc.nextDouble();
				
				Doctor newDoctor = new Doctor(Id, name, designation, fees);
				int status = dao.addDoctor(newDoctor);
				if(status ==1) {
					System.out.println("new doctor is added");
				}else {
					System.out.println("failed");
				}
				break;
			case 2:
				System.out.println("Display All Doctors");
				dao.getAllDoctors().forEach(System.out :: println);
				
				break;
			case 3:
				System.out.println("Upadate Doctor");
				System.out.println("doctorId");
				Id= sc.next();
				System.out.println("doctorName");
				name =sc.next();
				System.out.println("doctorDesignation");
				designation =sc.next();
				System.out.println("DoctorFees");
				fees =sc.nextDouble();
				Doctor updateDoctor = new Doctor(Id, name, designation, fees);
				updateDoctor.setDoctorId(Id);
				int updateStatus = dao.updateDoctor(updateDoctor);
				if(updateStatus >0) {
					System.out.println("doctor details updated");
				}else {
					System.out.println("failed");
				}
			break;
			case 4:
				System.out.println("Delete Doctor");
				System.out.println("Enter the doctor's name to delete: ");
				String delete = sc.next();
				int deleteStatus = dao.deleteDoctor(delete);
				if(deleteStatus == 1) {
					System.out.println("Doctor deleted successfully.");
				}else {
					System.out.println("Failed to delete doctor or doctor not found.");
				}
				break;
			case 5:
				System.out.println("search Doctor");
				System.out.println("Enter the doctor's name to search: ");
				name =sc.next();
				Doctor searchDoctor = dao.searchDoctor(name);
				if(searchDoctor != null) {
				System.out.println("doctor id: "+searchDoctor.getDoctorId() );
				System.out.println("doctor name: "+ searchDoctor.getName());
				System.out.println("doctor designation: "+searchDoctor.getDesignation());
				System.out.println("doctor fees: "+ searchDoctor.getFees());
				}else {
					System.out.println("doctor not found");
				}
				break;
			case 6:
				System.out.println("Delete all Doctors");
				dao.deleteAllDoctors();
				System.out.println(" total doctor details deleted");
				
				break;
			case 0:
				System.out.println("Bye");
				System.exit(0);
				break;
			}
			
		}while (option != 0);
	
		
	}

}
