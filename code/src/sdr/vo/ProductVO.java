package sdr.vo;

public class ProductVO {

	String prodname;
	String brand;
	int price;
	String speccpu;
	String specram;
	String specstorage;
	String specsize;
	String specimg;
	int stock;
	String proddate;
	
	
	
	public ProductVO() {
		super();
	}

	public ProductVO(String prodname, String brand, int price, String speccpu, String specram, String specstorage,
			String specsize, String specimg, int stock, String proddate) {
		super();
		this.prodname = prodname;
		this.brand = brand;
		this.price = price;
		this.speccpu = speccpu;
		this.specram = specram;
		this.specstorage = specstorage;
		this.specsize = specsize;
		this.specimg = specimg;
		this.stock = stock;
		this.proddate = proddate;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSpeccpu() {
		return speccpu;
	}

	public void setSpeccpu(String speccpu) {
		this.speccpu = speccpu;
	}

	public String getSpecram() {
		return specram;
	}

	public void setSpecram(String specram) {
		this.specram = specram;
	}

	public String getSpecstorage() {
		return specstorage;
	}

	public void setSpecstorage(String specstorage) {
		this.specstorage = specstorage;
	}

	public String getSpecsize() {
		return specsize;
	}

	public void setSpecsize(String specsize) {
		this.specsize = specsize;
	}

	public String getSpecimg() {
		return specimg;
	}

	public void setSpecimg(String specimg) {
		this.specimg = specimg;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProddate() {
		return proddate;
	}

	public void setProddate(String proddate) {
		this.proddate = proddate;
	}

	@Override
	public String toString() {
		return "ProductVO [prodname=" + prodname + ", brand=" + brand + ", price=" + price + ", speccpu=" + speccpu
				+ ", specram=" + specram + ", specstorage=" + specstorage + ", specsize=" + specsize + ", specimg="
				+ specimg + ", stock=" + stock + ", proddate=" + proddate + ", getProdname()=" + getProdname()
				+ ", getBrand()=" + getBrand() + ", getPrice()=" + getPrice() + ", getSpeccpu()=" + getSpeccpu()
				+ ", getSpecram()=" + getSpecram() + ", getSpecstorage()=" + getSpecstorage() + ", getSpecsize()="
				+ getSpecsize() + ", getSpecimg()=" + getSpecimg() + ", getStock()=" + getStock() + ", getProddate()="
				+ getProddate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
