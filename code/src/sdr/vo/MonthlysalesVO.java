package sdr.vo;

public class MonthlysalesVO {

	int Month;
	int price;

	public MonthlysalesVO() {
		super();
	}

	public MonthlysalesVO(int month, int price) {
		super();
		Month = month;
		this.price = price;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MonthlysalesVO [Month=" + Month + ", price=" + price + "]";
	}

}
