package com.edubrige.doctorApp1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

	public static Connection getConnection() {
		Connection con = null;
		
		String driver, url, user, password;
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/edb10229";
		user = "root";
		password = "root";
		
		try {
			Class.forName(driver);
			}catch (ClassNotFoundException e) {
				System.out.println("Driver not found");
			}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return con;
	
	}
}

