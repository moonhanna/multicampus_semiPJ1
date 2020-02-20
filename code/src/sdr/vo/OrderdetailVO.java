package sdr.vo;

public class OrderdetailVO {

	String orderdetailno;
	String prodname;
	int prodquantity;
	int prodprice;
	String orderno;

	public OrderdetailVO() {
		super();
	}

	public OrderdetailVO(String orderdetailno, String prodname, int prodquantity, int prodprice, String orderno) {
		super();
		this.orderdetailno = orderdetailno;
		this.prodname = prodname;
		this.prodquantity = prodquantity;
		this.prodprice = prodprice;
		this.orderno = orderno;
	}

	public String getOrderdetailno() {
		return orderdetailno;
	}

	public void setOrderdetailno(String orderdetailno) {
		this.orderdetailno = orderdetailno;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getProdquantity() {
		return prodquantity;
	}

	public void setProdquantity(int prodquantity) {
		this.prodquantity = prodquantity;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	@Override
	public String toString() {
		return "OrderdetailVO [orderdetailno=" + orderdetailno + ", prodname=" + prodname + ", prodquantity="
				+ prodquantity + ", prodprice=" + prodprice + ", orderno=" + orderno + "]";
	}

}
