package com.edubrige.doctorApp1.service;

import java.util.List;

import com.edubrige.doctorApp1.dao.DoctorDao;
import com.edubrige.doctorApp1.dao.DoctorDaoImpl;
import com.edubrige.doctorApp1.model.Doctor;

public class DoctorServiceImpl implements DoctorService{
	DoctorDao dao = new DoctorDaoImpl();

	@Override
	public int addDoctor(Doctor doctor) {
		dao.addDoctor(doctor);
		return 0;
	}

	@Override
	public int updateDoctor(Doctor doctor) {
        dao.updateDoctor(doctor);
		return 0;
	}

	@Override
	public Doctor searchDoctor(String name) {
		dao.searchDoctor(name);
		return null;
	}

	@Override
	public int deleteDoctor(String name) {
		dao.deleteDoctor(name);
		return 0;
	}

	@Override
	public void deleteAllDoctors() {
		dao.deleteAllDoctors();
		
	}

	@Override
	public List<Doctor> getAllDoctors() {
		dao.getAllDoctors();
		return null;
	}

}
