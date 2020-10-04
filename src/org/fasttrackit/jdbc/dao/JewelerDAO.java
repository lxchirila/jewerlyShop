package org.fasttrackit.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import org.fasttrackit.jdbc.helpers.DBHelper;
import org.fasttrackit.jdbc.pojo.Jeweler;

public class JewelerDAO {

	public void createTable() {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		try {
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS Jeweler" + "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ " name VARCHAR(255) NOT NULL, " + " phone VARCHAR(255) NOT NULL," + " email VARCHAR(255) NOT NULL, "
					+ " country VARCHAR(255) NOT NULL, " + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println("The Jewelers table was created successfully!");
		} catch (SQLException e) {
			System.out.println("Error on JewelerDAO.createTable(): " + e.getMessage());
		}
		helper.closeConnection(conn);
	}

	public void insertJeweler(Jeweler j) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String insertUser = "insert into jeweler(name,phone,email,country)" + "values (?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(insertUser);
		ps.setString(1, j.getName());
		ps.setString(2, j.getPhone());
		ps.setString(3, j.getEmail());
		ps.setString(4, j.getCountry());
		ps.executeUpdate();

		System.out.println("Jeweler added succesfully!");

		helper.closeConnection(conn);
	}

	public ArrayList<Jeweler> getJewelers() throws SQLException {
		ArrayList<Jeweler> jewelers = new ArrayList<Jeweler>();

		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String sqlString = "select * from jeweler";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);
		while (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String country = rs.getString("country");
			Jeweler j = new Jeweler(id, name, phone, email, country);

			jewelers.add(j);

		}
		helper.closeConnection(conn);
		return jewelers;
	}

	public Jeweler getJewelerById(int id) throws SQLException {
		Jeweler jeweler = null;
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String sqlString = "select * from jeweler where id=?";
		PreparedStatement stmt = conn.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String country = rs.getString("country");
			jeweler = new Jeweler(id, name, phone, email, country);
		}
		helper.closeConnection(conn);
		return jeweler;
	}

	public void updateJeweler(Jeweler j) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String updateJeweler = "update jeweler set name=?, phone=?, email=?, country=? where id=?";

		PreparedStatement ps = conn.prepareStatement(updateJeweler);
		ps.setString(1, j.getName());
		ps.setString(2, j.getPhone());
		ps.setString(3, j.getEmail());
		ps.setString(4, j.getCountry());
		ps.setInt(5, j.getId());
		ps.executeUpdate();

		helper.closeConnection(conn);
	}

	public void deleteJeweler(int id) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnection();

		String deleteString = "delete from jeweler where id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		helper.closeConnection(con);

	}

	public void deleteJeweler(Jeweler j) throws SQLException {
		deleteJeweler(j.getId());
	}

}
