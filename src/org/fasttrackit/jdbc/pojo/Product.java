package org.fasttrackit.jdbc.pojo;

public class Product {
	private int id;
	private String description;
	private int price;
	private int stock;

	public Product() {

	}

	public Product(int id, String description, int price, int stock) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", stock=" + stock + "]";
	}

}
