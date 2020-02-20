package sdr.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.CartVO;
import sdr.vo.OrderdetailVO;
import sdr.vo.ProductVO;
import sdr.vo.UserorderVO;

@Controller
public class SaveDBController {
	
	@Resource(name = "orderdetailservice")
	Service<String, OrderdetailVO> service;
	
	@Resource(name = "userorderservice")
	Service<String, UserorderVO> uoservice;

	@Resource(name = "cartservice")
	Service<String,CartVO> cservice;
	
	@Resource(name="productservice")
	Service<String, ProductVO> pservice;

	@RequestMapping("/saveorderinfo.mc")
	public ModelAndView saveorder(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/json;charset=UTF-8");
		ModelAndView mv = new ModelAndView();

		String prodname = request.getParameter("prodname");
		int prodqnt = Integer.parseInt(request.getParameter("prodqnt"));
		int prodprice = Integer.parseInt(request.getParameter("prodprice"));
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("loginid");

		
		UserorderVO userirder = new UserorderVO(null, userid,"card", prodqnt, prodqnt*prodprice, null);
		
		try {
			uoservice.register(userirder);
			System.out.println("uoservice register ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserorderVO neworder = new UserorderVO();
		try {
			neworder = uoservice.getnew();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		OrderdetailVO od = new OrderdetailVO(null, prodname, prodqnt, prodprice, neworder.getOrderno());	
	
		try {
			service.register(od);
			System.out.println("register ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/savecartorder.mc")
	public ModelAndView savecartorder(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/json;charset=UTF-8");
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("loginid");
		
		//ArrayList<ProductVO> plist = new ArrayList<>();
		ArrayList<String> pnamelist = new ArrayList<>();
		ArrayList<Integer> pquanlist = new ArrayList<>();
		
		ArrayList<CartVO> cartno = new ArrayList<>();
		CartVO cv = new CartVO();
		int cart_all_quantity = 0;
		int cart_price = 0;
		
		try {
			cartno = cservice.selectAllCart(userid);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	
		for(int i=0; i<cartno.size(); i++)
		{
			cv = cartno.get(i);
			cart_all_quantity += cv.getQuantity();
			cart_price += cv.getPrice();
			try {
				cservice.deleteCart(cartno.get(i).getCartno());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("지웠냐??");

		
		UserorderVO userirder = new UserorderVO(null, userid,"card", cart_all_quantity, cart_price, null);
		
		try {
			uoservice.register(userirder);
			System.out.println("uoservice register ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//orderdetial save
		UserorderVO neworder = new UserorderVO();
		try {
			neworder = uoservice.getnew();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ArrayList<OrderdetailVO> odlist = new ArrayList<>();
		OrderdetailVO od = new OrderdetailVO();
		CartVO cart = new CartVO();
		for(int i =0; i<cartno.size(); i++) {
			cart = cartno.get(i);
			odlist.add(new OrderdetailVO(null, cart.getProdname(), cart.getQuantity(), cart.getPrice(), neworder.getOrderno()));
			System.out.println(odlist);
			pnamelist.add(cart.getProdname());
			pquanlist.add(cart.getQuantity());
			
			System.out.println(pnamelist);
			System.out.println(pquanlist);
		}
	
		for(int i=0; i<odlist.size(); i++)
		{
			od = odlist.get(i);
			try {
				service.register(od);
				System.out.println("Orderdetail register ok!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<pnamelist.size(); i++)
		{
			ProductVO pv = new ProductVO();
			try {
				pv = pservice.get(pnamelist.get(i));
				String ddd = pv.getProddate();
				String ttt = ddd.substring(0, 10);
				System.out.println(ttt);
				StringBuilder builder = new StringBuilder(ttt);
				builder.setCharAt(4, '/');
				builder.setCharAt(7, '/');			
				System.out.println(builder.toString());
				System.out.println("재고량"+pv.getStock());
				System.out.println("내가 산거" + pquanlist.get(i));
				ProductVO tmp = new ProductVO(pv.getProdname(),pv.getBrand(),pv.getPrice(),pv.getSpeccpu(),pv.getSpecram(),pv.getSpecstorage(),pv.getSpecsize(),pv.getSpecimg(), pv.getStock()-pquanlist.get(i),builder.toString());
				pservice.modify(tmp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("main");
		return mv;
	}
	
}
