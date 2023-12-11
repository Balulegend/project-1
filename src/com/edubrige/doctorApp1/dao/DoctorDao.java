package com.edubrige.doctorApp1.dao;

import java.util.List;

import com.edubrige.doctorApp1.model.Doctor;

public interface DoctorDao {
	int addDoctor(Doctor doctor);
	int updateDoctor(Doctor name);
	Doctor searchDoctor (String name);
	int deleteDoctor (String name);
	void deleteAllDoctors();
	List<Doctor> getAllDoctors();
}

