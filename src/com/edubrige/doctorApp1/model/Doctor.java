package com.edubrige.doctorApp1.model;

public class Doctor {
	private String doctorId;
	private String name;
	private String designation;
	private double fees;
	
	
	public Doctor() {
		super();
	}


	public Doctor(String doctorId, String name, String designation, double fees) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.designation = designation;
		this.fees = fees;
	}


	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getFees() {
		return fees;
	}


	public void setFees(double fees) {
		this.fees = fees;
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", designation=" + designation + ", fees=" + fees
				+ "]";
	}
	
	

}
