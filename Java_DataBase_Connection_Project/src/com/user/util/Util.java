package com.user.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	
//	DataBase Connection Logic
	
	private static String url = "jdbc:mysql://localhost:3306/JDBC_Operation";
	private static String username = "root";
	private static String password = "Darshan@2004";
	
	public static Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();	
		}
		return con;
	}
}
