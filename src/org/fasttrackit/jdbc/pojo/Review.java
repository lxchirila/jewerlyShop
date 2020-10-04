package org.fasttrackit.jdbc.pojo;

public class Review {
	private int id;
	private String text;
	private int rating;

	public Review() {

	}

	public Review(int id, String text, int rating) {
		super();
		this.id = id;
		this.text = text;

		this.rating = rating;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", text=" + text + ", rating=" + rating + "]";
	}

}
