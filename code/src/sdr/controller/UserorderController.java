package sdr.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.CartVO;
import sdr.vo.ProductVO;
import sdr.vo.UserVO;

@Controller
public class UserorderController {
	
	@Resource(name = "userservice")
	Service<String, UserVO> uservice;
	
	@Resource(name = "productservice")
	Service<String, ProductVO> pservice;
	
	@Resource(name = "cartservice")
	Service<String,CartVO> cservice;
	
	@RequestMapping("/userorder.mc")
	public ModelAndView userorder(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		ModelAndView mv = new ModelAndView();
		
		String prodname = request.getParameter("prodname");
		ProductVO prodinfo = new ProductVO();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("loginid");
		
		UserVO user = new UserVO();		
		try {
			user = uservice.get(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int qnt = Integer.parseInt(request.getParameter("qnt"));
		
		try {
			prodinfo = pservice.get(prodname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("user", user);
		mv.addObject("prodname", prodname);
		mv.addObject("prodqnt", qnt);
		mv.addObject("priceall", prodinfo.getPrice() * qnt);
		mv.addObject("prodinfo", prodinfo);
		mv.addObject("center", "checkout");
		mv.setViewName("main");
		return mv;
	}
	
	
//	@RequestMapping("/order.mc")
//	public ModelAndView order() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("order", "userorder");
//		mv.setViewName("checkout");
//		return mv;
//	}
	
	@RequestMapping("/cartorder.mc")
	public ModelAndView cartorder(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("loginid");
		
		UserVO user = new UserVO();		
		try {
			user = uservice.get(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<CartVO> cartno = new ArrayList<>();
		CartVO cv = new CartVO();
		int cart_price = 0;
		
		try {
			cartno = cservice.selectAllCart(userid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for(int i=0; i<cartno.size(); i++)
		{
			cv = cartno.get(i);
			cart_price += cv.getPrice() * cv.getQuantity();
		}
		//list -> cart_info
		mv.addObject("user", user);
		mv.addObject("cart_info", cartno);
		mv.addObject("priceall", cart_price);
		mv.addObject("prodinfo", null);
		mv.addObject("center", "checkout");
		mv.setViewName("main");
		return mv;
	}
}
