package org.fasttrackit.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.fasttrackit.jdbc.helpers.DBHelper;
import org.fasttrackit.jdbc.pojo.Product;

public class ProductDAO {
	private DBHelper helper = new DBHelper();
	private Connection conn = helper.getConnection();

	public void createTable() {
		try {
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS Product" + "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ " description VARCHAR(255) NOT NULL," + " price INTEGER NOT NULL," + " stock INTEGER NOT NULL,"
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println("The Product table was created successfully!");
		} catch (SQLException e) {
			System.out.println("Error on productDAO.createTable(): " + e.getMessage());
		}
		helper.closeConnection(conn);

	}

	public void insertProduct(Product p) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String insertProduct = "insert into product(id,description,price,stock)" + "values (?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(insertProduct);
		ps.setInt(1, p.getId());
		ps.setString(2, p.getDescription());
		ps.setInt(3, p.getPrice());
		ps.setInt(4, p.getStock());
		ps.executeUpdate();

		System.out.println("Product added succesfully!");

		helper.closeConnection(conn);
	}

	public List<Product> getProducts() throws SQLException {
		List<Product> products = new ArrayList<Product>();

		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();

		String sqlString = "select * from product";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);
		while (rs.next()) {

			int id = rs.getInt("id");
			String description = rs.getString("description");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			Product p = new Product(id, description, price, stock);

			products.add(p);

		}
		helper.closeConnection(conn);
		return products;
	}

	public Product getProductById(int id) throws SQLException {
		Product product = null;
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String sqlString = "select * from product where id=?";
		PreparedStatement stmt = conn.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			String description = rs.getString("description");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			product = new Product(id, description, price, stock);
		}
		helper.closeConnection(conn);
		return product;
	}

	public void updateProduct(Product p) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection conn = helper.getConnection();
		String updateProduct = "update product set description=?, price=?,stock=? where id=?";

		PreparedStatement ps = conn.prepareStatement(updateProduct);
		ps.setString(1, p.getDescription());
		ps.setInt(2, (int) p.getPrice());
		ps.setInt(3, p.getStock());
		ps.setInt(4, p.getId());
		ps.executeUpdate();

		helper.closeConnection(conn);
	}

	public void deleteProduct(int id) throws SQLException {
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnection();

		String deleteString = "delete from product where id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		helper.closeConnection(con);

	}

	public void deleteProduct(Product p) throws SQLException {
		deleteProduct(p.getId());
	}

}
