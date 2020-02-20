package app.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sdr.frame.Service;
import sdr.vo.ProductVO;
import sdr.vo.CartVO;
public class ProductInsert {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Service service = (Service) factory.getBean("cartservice");
		
		CartVO cart = new CartVO();
		cart.setProdname("ASUS85");
		cart.setUserid("id01");
		cart.setQuantity(1);
		
		/*
		 * String prodname; String brand; int price; String speccpu; String specram;
		 * String specstorage; String specsize; String specimg; int stock; String
		 * proddate;
		 */
		
		
		try {
			service.insertCart(cart);;
			System.out.println("register ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	factory.close();	

	}

}
