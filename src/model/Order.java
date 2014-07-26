package model;

import java.util.Date;
import java.util.List;

public class Order {
	private long id;
	private Date date;
	private float totalFee;
	private Customer customer;
	private List<OrderDetail> detailList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	/** 合計金額の計算 */
	public void sumPrice(){
		totalFee = 0;
		for (OrderDetail od : detailList) {
			if (od.getItem() != null){
				totalFee += ( od.getItem().getPrice() * od.getAmount() );
			}
		}
	}
	/** 合計点数を計算 */
	public int count(){
		int count = 0;
		for(OrderDetail od : detailList){
			count += od.getAmount();
		}
		return count;
	}
}
