package app.product;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import sdr.frame.Service;
import sdr.vo.ProductVO;

public class ProductSeletAll {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Service service = (Service) factory.getBean("productservice");

		ArrayList<ProductVO> list = null;

		try {
			list = service.get();

			for (ProductVO u : list) {
				System.out.println(u);
			}

		} catch (Exception e) {
			System.out.println("ProductSeletAll fail");
			e.printStackTrace();
		}

		factory.close();

	}

}
