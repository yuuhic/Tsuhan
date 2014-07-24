package model;

public class OrderDetail {
	Order order;
	Book book;
	Cd cd;
	int amount; // 個数
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Cd getCd(){
		return cd;
	}
	public void setCd(Cd cd){
		this.cd = cd;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
