package app.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sdr.frame.Service;
import sdr.vo.ProductVO;

public class ProductUpsate {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("spring.xml");

		Service service = (Service) factory.getBean("productservice");
		
		ProductVO product = new ProductVO("삼성전자 노트북 PEN S NT950SBE-X716A","SAMSUNG",2211000,"i7","16GB","256GB","14","삼성전자 노트북 PEN S NT950SBE-X716A.jpg",50);

		try {
			service.modify(product);
			System.out.println("modify ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	factory.close();	

	}

}
