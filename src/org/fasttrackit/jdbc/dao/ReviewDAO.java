package org.fasttrackit.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.jdbc.helpers.DBHelper;

import org.fasttrackit.jdbc.pojo.Review;

public class ReviewDAO {
	private DBHelper helper = new DBHelper();
	private Connection conn = helper.getConnection();

	public void createTable() {
		try {
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS Review" + "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ " text VARCHAR(255) NOT NULL," + " rating INTEGER NOT NULL," + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println("The Review table was created successfully!");
		} catch (SQLException e) {
			System.out.println("Error on reviewDAO.createTable(): " + e.getMessage());
		}
		helper.closeConnection(conn);

	}

	public void insertReview(Review r) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String insertReview = "insert into review(id,text,rating)" + "values (?,?,?)";

		PreparedStatement ps = conn.prepareStatement(insertReview);
		ps.setInt(1, r.getId());
		ps.setString(2, r.getText());
		ps.setInt(3, r.getRating());

		ps.executeUpdate();

		System.out.println("Review added succesfully!");

		helper.closeConnection(conn);
	}

	public ArrayList<Review> getReviews() throws SQLException {
		ArrayList<Review> reviews = new ArrayList<Review>();

		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String sqlString = "select * from review";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);
		while (rs.next()) {

			int id = rs.getInt("id");
			String text = rs.getString("text");
			int rating = rs.getInt("rating");
			Review r = new Review(id, text, rating);

			reviews.add(r);

		}
		helper.closeConnection(conn);
		return reviews;
	}

	public Review getReviewById(int id) throws SQLException {
		Review review = null;
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String sqlString = "select * from review where id=?";
		PreparedStatement stmt = conn.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			String text = rs.getString("text");
			int rating = rs.getInt("rating");
			review = new Review(id, text, rating);
		}
		helper.closeConnection(conn);
		return review;
	}

	public void updateReview(Review r) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String updateReview = "update review set text=?, rating=? where id=?";

		PreparedStatement ps = conn.prepareStatement(updateReview);
		ps.setString(1, r.getText());
		ps.setInt(2, r.getRating());
		ps.setInt(3, r.getId());
		ps.executeUpdate();

		helper.closeConnection(conn);
	}

	public void deleteReview(int id) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnection();

		String deleteString = "delete from review where id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		helper.closeConnection(con);

	}

	public void deleteReview(Review r) throws SQLException {
		deleteReview(r.getId());
	}
}
