package sdr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.AnswerVO;
import sdr.vo.BoardVO;
import sdr.vo.MonthlysalesVO;
import sdr.vo.ProductVO;
import sdr.vo.UserorderVO;

@Controller
public class AdminpageController {
	
	@Resource(name = "userorderservice")
	Service<String, UserorderVO> service;
	
	@Resource(name="productservice")
	Service<String, ProductVO> pservice;
	

	@Resource(name="boardservice")
	Service<String, BoardVO> bservice;
	
	@Resource(name="answerservice")
	Service<String, AnswerVO> aservice;
	
	ArrayList<UserorderVO> orderlist = new ArrayList<>();
	ArrayList<BoardVO> boardlist = new ArrayList<>();
	ArrayList<AnswerVO> Answerlist = new ArrayList<>();
	
	@RequestMapping("/goadmin.mc")
	public ModelAndView goadmin() {
		System.out.println("goadmin들옴");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("../slide/admin");
		return mv;
	}
	
	
	@RequestMapping("/getdata.mc")
	public void getdata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json; charset=EUC-KR");
		System.out.println("getdata들옴");
		
		try {
			orderlist = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserorderVO tmp = new UserorderVO();
		ArrayList<MonthlysalesVO> getMonthlysalesData = new ArrayList<>();

		for(int i = 0; i<orderlist.size();i++)
		{
			tmp = orderlist.get(i);
			getMonthlysalesData.add(new MonthlysalesVO(tmp.getOrderdate().getMonth(),tmp.getTotalprice()));
		}

		JSONArray ja = new JSONArray();
		
		for(MonthlysalesVO Monthly_Data_list : getMonthlysalesData) {
			JSONObject obj = new JSONObject();
			obj.put("Month", Monthly_Data_list.getMonth()+1);
			obj.put("price", Monthly_Data_list.getPrice());
			ja.add(obj);
		}
		
		System.out.println(ja);
		PrintWriter out = response.getWriter();
		out.write(ja.toJSONString());
		out.close();

	}
	
	@RequestMapping("/boarddata.mc")
	public void boarddata(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json; charset=EUC-KR");
		System.out.println("boarddata들옴");

		try {
			boardlist = bservice.get();
			System.out.println("boardlist" + boardlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray ja = new JSONArray();
		
		for(BoardVO board : boardlist) {
			JSONObject obj = new JSONObject();
			obj.put("boardno", board.getBoardno());
			obj.put("userid", board.getUserid());
			obj.put("bcontent", board.getBcontent());
			obj.put("bdate", board.getBdate());
			obj.put("prodname", board.getProdname());
			obj.put("btype", board.getBtype());
			obj.put("bstar", board.getBstar());
			ja.add(obj);
		}
		
		System.out.println(ja);
		PrintWriter out = response.getWriter();
		out.write(ja.toJSONString());
		out.close();
		
	}
	
	@RequestMapping("/banswerimpl.mc")
	public String banswerimpl(HttpServletRequest request, HttpServletResponse response) {
	
		String bcontent = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			bcontent = request.getParameter("bcontent");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String boardno = request.getParameter("boardno");
		System.out.println(boardno + bcontent);
		
		
		AnswerVO an= new AnswerVO(null,bcontent,Integer.parseInt(boardno));
		try {
			aservice.register(an);
			System.out.println("ok!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:goadmin.mc";
		
	}
	
	@RequestMapping("/getanswer.mc")
	public void getanswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json; charset=EUC-KR");
		System.out.println("getanswer들옴");

		try {
			Answerlist = aservice.get();
			System.out.println("Answerlist" + Answerlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray ja = new JSONArray();
		
		for(AnswerVO answer : Answerlist) {
			JSONObject obj = new JSONObject();
			obj.put("banswerno", answer.getBanswerno());
			obj.put("acontent", answer.getAcontent());
			obj.put("boardno", answer.getBoardno());
			ja.add(obj);
		}
		
		System.out.println(ja);
		PrintWriter out = response.getWriter();
		out.write(ja.toJSONString());
		out.close();
		
	}
	
	

}
