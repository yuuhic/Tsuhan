package model;

import java.util.List;

public class Book {
	private String title;
	private String isbn;
	private float price;
	private List<Auther> autherList;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Auther> getAutherList() {
		return autherList;
	}
	public void setAutherList(List<Auther> autherList) {
		this.autherList = autherList;
	}


}
