package com.edubrige.doctorApp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubrige.doctorApp1.model.Doctor;
import com.edubrige.doctorApp1.util.DatabaseUtil;

public class DoctorDaoImpl implements DoctorDao {
	private static Connection con = DatabaseUtil.getConnection();
	PreparedStatement ps = null;

	@Override
	public int addDoctor(Doctor doctor) {
		String insert = "INSERT INTO doctor VALUES(?,?,?,?)";
		int status = 0;
		
		try {
			 ps = con.prepareStatement(insert);
			ps.setString(1, doctor.getDoctorId());
			ps.setString(2,doctor.getName());
			ps.setString(3, doctor.getDesignation());
			ps.setDouble(4, doctor.getFees());
		
	          status = ps.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return status;
	}

	@Override
	public int updateDoctor(Doctor doctor) {
		String update = "UPDATE doctor SET name = ?, designation = ?, fees = ? WHERE id =?";
		int status = 0;
		try 
			( PreparedStatement ps = con.prepareStatement(update)) {
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getDesignation());
			ps.setDouble(3, doctor.getFees());
			ps.setString(4, doctor.getDoctorId());
			status = ps.executeUpdate();
			 }
		catch (SQLException e) {
				e.printStackTrace();
			}
		
				return status;
	}
	

	@Override
	public Doctor searchDoctor(String name) {
		Doctor doctor = new Doctor();
	 String search = "SELECT * FROM doctor WHERE name LIKE ?";
	 int status =0;
	 try {
	 ps = con.prepareStatement(search);
	 ps.setString(1,"%"+name+"%");
	 ResultSet rs=  ps.executeQuery();
	 if(rs.next()) {
		 doctor = new Doctor();
		 doctor.setDoctorId(rs.getString("id"));
		 doctor.setName(rs.getString("name"));
		 doctor.setDesignation(rs.getString("designation"));
		 doctor.setFees(rs.getDouble("fees"));
	 }
	 } catch (SQLException e) {
         e.printStackTrace();
	 }
		return doctor;
	}

	@Override
	public int deleteDoctor(String name) {
		String delete ="DELETE FROM doctor WHERE name = ?";
		int status = 0;
		try {
		 ps = con.prepareStatement(delete);
		 ps.setString(1, name);
		 status = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void deleteAllDoctors() {
		String deleteAll = "TRUNCATE TABLE doctor";
		int status = 0;
		try {
			ps = con.prepareStatement(deleteAll);
			status = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ;
	
		
	}

	@Override
	public List<Doctor> getAllDoctors() {
		String  select = "SELECT id,name,designation,fees FROM doctor";
		PreparedStatement ps = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {
			ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setDoctorId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setDesignation(rs.getString("designation"));
				d.setFees(rs.getDouble("fees"));
				doctors.add(d);
				
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

}
