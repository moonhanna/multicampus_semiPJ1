package sdr.vo;

public class CartDetailVO {

	String cartno;
	String userid;
	String prodname;
	int quantity;
	int price;
	int money;
	String specimg;
	
	
	
	public CartDetailVO() {
		super();
	}

	public CartDetailVO(String cartno, String userid, String prodname, int quantity, int price, int money,
			String specimg) {
		super();
		this.cartno = cartno;
		this.userid = userid;
		this.prodname = prodname;
		this.quantity = quantity;
		this.price = price;
		this.money = money;
		this.specimg = specimg;
	}
	
	public String getCartno() {
		return cartno;
	}
	public void setCartno(String cartno) {
		this.cartno = cartno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getSpecimg() {
		return specimg;
	}
	public void setSpecimg(String specimg) {
		this.specimg = specimg;
	}

	@Override
	public String toString() {
		return "CartDetailVO [cartno=" + cartno + ", userid=" + userid + ", prodname=" + prodname + ", quantity="
				+ quantity + ", price=" + price + ", money=" + money + ", specimg=" + specimg + "]";
	}

	

}
