package app.product;

import java.util.*;

public class DataMaker {/////////// 랜덤한 데이터 만들기
	public static void main(String[] args) {
		StringBuilder query = new StringBuilder();
		int price = 0;
		Random rand = new Random();
		;
		price = rand.nextInt((5000000 - 400000) + 1) + 400000;
		String[] brand = { "ASUS", "SAMSUNG", "LG", "HP", "DELL" };
		String[] speccpu = { "I5", "I7", "I3", "I9", "RYZEN" };
		String[] specram = { "4GB", "8GB", "16GB", "32GB" };
		String[] specstorage = { "128GB", "256GB", "512GB", "1TB" };
		String[] specsize = { "13.3", "14", "15.6", "17" };
		String[] specimg = { "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg"};
		int stock = 50;

		int brandRand = rand.nextInt(brand.length);
		int speccpuRand = rand.nextInt(speccpu.length);
		int specramRand = rand.nextInt(specram.length);
		int specstorageRand = rand.nextInt(specstorage.length);
		int specsizeRand = rand.nextInt(specsize.length);
		int specimgRand = rand.nextInt(specimg.length);

		/*
		 * INSERT INTO PRODUCT
		 * (PRODNAME,BRAND,PRICE,SPECCPU,SPECRAM,SPECSTORAGE,SPECSIZE,SPECIMG,STOCK,
		 * proddate)
		 * VALUES('삼성전자_노트북_PEN_S_NT950SBE-X716A','SAMSUNG',2211000,'I7','16GB','256GB',
		 * '14','1.jpg',50, sysdate);
		 */

		System.out.println("몇개의 쿼리문 만들거?? specimg는 브랜드 다 통합해서 랜덤");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i =1; i < n; i++) {
			price = rand.nextInt((5000000 - 400000) + 1) + 400000;
			brandRand = rand.nextInt(brand.length);
			speccpuRand = rand.nextInt(speccpu.length);
			specramRand = rand.nextInt(specram.length);
			specstorageRand = rand.nextInt(specstorage.length);
			specsizeRand = rand.nextInt(specsize.length);
			specimgRand = rand.nextInt(specimg.length);

			query.append("INSERT INTO PRODUCT (PRODNAME,BRAND,PRICE,SPECCPU,"
					+ "SPECRAM,SPECSTORAGE,SPECSIZE,SPECIMG,STOCK, proddate)VALUES('");
			query.append(brand[brandRand] + Integer.toString(i) + "','" + brand[brandRand] + "'," + price + ",'"
					+  speccpu[speccpuRand]+ "','"+ specram[specramRand]+ "','"+ specstorage[specstorageRand] +  "','"
					+   specsize[specsizeRand]+ "','" +brand[brandRand] +specimg[specimgRand] + "'," + Integer.toString(stock)
					+ ", sysdate);"); /////////// 브랜드 이름
			System.out.println(query);
			query.delete(0, query.length());/// 쿼리문 초기화
		}
	}
}
