package sdr.vo;

import java.util.Date;

public class UserorderVO {

	String orderno;
	String userid;
	String payment;
	int totalquantity;
	int totalprice;
	Date orderdate;

	public UserorderVO() {
		super();
	}

	public UserorderVO(String orderno, String userid, String payment, int totalquantity, int totalprice,
			Date orderdate) {
		super();
		this.orderno = orderno;
		this.userid = userid;
		this.payment = payment;
		this.totalquantity = totalquantity;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "UserorderVO [orderno=" + orderno + ", userid=" + userid + ", payment=" + payment + ", totalquantity="
				+ totalquantity + ", totalprice=" + totalprice + ", orderdate=" + orderdate + "]";
	}

}
