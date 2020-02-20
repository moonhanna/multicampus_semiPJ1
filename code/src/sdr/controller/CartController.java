package sdr.controller;

import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sdr.vo.UserVO;

import sdr.frame.Service;
import sdr.vo.CartVO;

@Controller
public class CartController {

	
	
	@Resource(name = "cartservice")
	Service<String, CartVO> service;
	
	/*
	@RequestMapping("/popular.mc") ////////// 메인 화면에 5개의 인기상품 뽑기
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
*/
	/*
	@RequestMapping("/uu.mc")
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<UserVO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(UserVO u:list) {
			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("pwd", u.getPwd());
			jo.put("name", u.getName());
			ja.add(jo);
		}
		out.print(ja.toJSONString());
		out.close();
	}
	*/
	@RequestMapping("/showUserCart.mc")
	@ResponseBody
	public void showUserCart(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("loginid");
		ArrayList<CartVO> myCart = null;
		try {
			myCart = service.selectAllCart(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(CartVO u: myCart) {
			JSONObject jo = new JSONObject();
			jo.put("userid", u.getUserid());
			jo.put("prodname", u.getProdname());
			jo.put("quantity", u.getQuantity());
			jo.put("cartno", u.getCartno());
			jo.put("price" ,u.getPrice());
			jo.put("specimg" ,u.getSpecimg());
			jo.put("money", u.getMoney());
			ja.add(jo);
		}
		out.print(ja.toJSONString());
		out.close();
	}

	@RequestMapping("/checkDuplicateDataAdd.mc")
	@ResponseBody
	public void cartDuplicateDataAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("userid");
		String name = request.getParameter("prodname");
		//"id01"
		String userid = id.substring( 1, id.length()-1);
		String prodname = name.substring(name.indexOf("\"") + 1, name.length()-1);
		System.out.println(userid + " 와  그리고 :" + prodname);
		
		CartVO v = new CartVO();
		v.setUserid(userid);
		v.setProdname(prodname);
		v.setQuantity(1);
		int countCart = 0;
		try {
			countCart = service.countCart(v);
			if(countCart == 0) {
				service.insertCart(v);
				countCart = service.countCart(v);
			}else if(countCart > 0){
				service.updateCart(v);
			}
			countCart++;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("quantity", countCart);
		ja.add(jo);
		out.print(ja.toJSONString());
		out.close();
		/*
		service.countCart(v);
		ArrayList<CartVO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(UserVO u:list) {
			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("pwd", u.getPwd());
			jo.put("name", u.getName());
			ja.add(jo);
		}
		out.print(ja.toJSONString());
		out.close();*/
	}
	
	@RequestMapping("/removeCartData.mc")
	@ResponseBody
	public void removeCartData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("hashlsakjsdlaksdalksdhlks");
		String userid = request.getParameter("userid").trim();
		String name = request.getParameter("prodname");
		//"id01"
		String prodname = name.substring(name.indexOf("\"") + 1, name.length()).trim();
		System.out.println(userid + " 와  그리고 :" + prodname);
		CartVO v = new CartVO();
		v.setCartno("haha");
		v.setUserid(userid);
		v.setProdname(prodname);
		
		try {
			String cartno = null;
			CartVO u = service.selectCart(v);
			if(u != null)
				cartno = u.getCartno();
			System.out.println(u.getQuantity());
			if(u.getQuantity() == 1) { /////////////////////////0이면 지우기
				service.deleteCart(cartno);
				System.out.println("hahahah");
			}else {
				System.out.println("before" + u.getQuantity());
				v.setQuantity(-1);
				service.updateCart(v);
				u= service.selectCart(v);
				System.out.println("after " + u.getQuantity());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		jo.put("success", 5);
		out.print(jo.toJSONString());
		out.close();
	}
}
