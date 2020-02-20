package app.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sdr.frame.Service;

public class ProductDelete {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("spring.xml");

		Service service = (Service) factory.getBean("productservice");
		
		try {
			service.remove("test");
			System.out.println("remove ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	factory.close();		
		
	}

}
