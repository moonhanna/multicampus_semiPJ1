package app.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sdr.frame.Service;
import sdr.vo.ProductVO;

public class ProductSelect {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("spring.xml");

		Service service = (Service) factory.getBean("productservice");

		ProductVO product = new ProductVO();

			try {
				product = (ProductVO) service.get("삼성전자 노트북 PEN S NT950SBE-X716A");
				System.out.println(product);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		factory.close();
		
	}

}
