package com.edubrige.doctorApp1.service;

import java.util.List;

import com.edubrige.doctorApp1.model.Doctor;

public interface DoctorService {
	int addDoctor(Doctor doctor);
	int updateDoctor(Doctor doctor);
	Doctor searchDoctor (String name);
	int deleteDoctor (String name);
	void deleteAllDoctors();
	List<Doctor> getAllDoctors();

}
