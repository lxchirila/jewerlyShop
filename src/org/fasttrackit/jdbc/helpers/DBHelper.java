package org.fasttrackit.jdbc.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	public Connection getConnection() {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "Siguranta1");
		try {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelry", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
