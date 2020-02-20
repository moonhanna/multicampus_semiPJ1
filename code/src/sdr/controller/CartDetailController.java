package sdr.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.CartDetailVO;

@Controller
public class CartDetailController {

	@Resource(name = "cartdetailService")
	Service<String, CartDetailVO> cartdetailService;

	@RequestMapping("/cartdetail.mc")
	@ResponseBody
	public ModelAndView cartdetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
 
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("loginid");
		
		ArrayList<CartDetailVO> list= new ArrayList<>();
		CartDetailVO cd = new CartDetailVO();
		int cart_all_quantity = 0;
		int cart_price = 0;
		
		try {
			list = cartdetailService.selectAllCart(userid);
			
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		for(int i=0; i<list.size(); i++)
		{
		   cd = list.get(i);
		   cart_all_quantity += cd.getQuantity();
		   cart_price += cd.getPrice() * cd.getQuantity();
		}
	
		mv.addObject("clist", list);
		  mv.addObject("cartprice", cart_price); 
		  mv.addObject("cartquantity",cart_all_quantity);
		
		mv.addObject("center", "cartdetail/list");
		
		mv.setViewName("main");
		return mv;
	}
	
	
	


//	@RequestMapping("/cartdetail.mc")
//	@ResponseBody
//	public void cartDuplicateDataAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.setContentType("text/json;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//
//		String id = request.getParameter("userid");
//		String name = request.getParameter("prodname");
//		// "id01"
//		String userid = id.substring(1, id.length() - 1);
//		String prodname = name.substring(name.indexOf("\"") + 1, name.length() - 1);
//		System.out.println(userid + "와 그리고" + prodname);
//
//		CartDetailVO v = new CartDetailVO();
//
//		v.setUserid(userid);
//		v.setProdname(prodname);
//		v.setQuantity(1);
//
//		int countCart = 0;
//		try {
//			countCart = cartdetailservice.countCart(v);
//
//			if (countCart == 0) {
//				cartdetailservice.insertCart(v);
//				countCart = cartdetailservice.countCart(v);
//			} else if (countCart > 0) {
//				cartdetailservice.updateCart(v);
//			}
//			countCart++;
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		JSONArray ja = new JSONArray();
//		JSONObject jo = new JSONObject();
//		jo.put("quantity", countCart);
//		ja.add(jo);
//		out.print(ja.toJSONString());
//		out.close();
//		/*
//		 * service.countCart(v); ArrayList<CartVO> list = null; try { list =
//		 * service.get(); } catch (Exception e) { e.printStackTrace(); } JSONArray ja =
//		 * new JSONArray(); for(UserVO u:list) { JSONObject jo = new JSONObject();
//		 * jo.put("id", u.getId()); jo.put("pwd", u.getPwd()); jo.put("name",
//		 * u.getName()); ja.add(jo); } out.print(ja.toJSONString()); out.close();
//		 */
//	}
//
//	@RequestMapping("/removeCartData.mc")
//	@ResponseBody
//	public void removeCartData(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.setContentType("text/json;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		System.out.println("test..");
//		String userid = request.getParameter("userid").trim();
//		String name = request.getParameter("prodname");
//		// "id01"
//		String prodname = name.substring(name.indexOf("\"") + 1, name.length()).trim();
//		System.out.println(userid + " ��  洹몃━怨� :" + prodname);
//		CartDetailVO v = new CartDetailVO();
//		v.setCartno("haha");
//		v.setUserid(userid);
//		v.setProdname(prodname);
//
//		try {
//			String cartno = null;
//			CartDetailVO u = cartdetailservice.selectCart(v);
//			if (u != null)
//				cartno = u.getCartno();
//			System.out.println(u.getQuantity());
//			if (u.getQuantity() == 1) { ///////////////////////// 0�씠硫� 吏��슦湲�
//				cartdetailservice.deleteCart(cartno);
//				System.out.println("systemsystem");
//			} else {
//				System.out.println("before" + u.getQuantity());
//				v.setQuantity(-1);
//				cartdetailservice.updateCart(v);
//				u = cartdetailservice.selectCart(v);
//				System.out.println("after " + u.getQuantity());
//			}
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		JSONObject jo = new JSONObject();
//		jo.put("success..", 5);
//		out.print(jo.toJSONString());
//		out.close();
//	}
}
