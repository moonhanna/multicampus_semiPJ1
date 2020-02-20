package sdr.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.CartVO;
import sdr.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userservice")
	Service<String, UserVO> service;
	
	@Autowired
	@Qualifier("cartservice")
	Service<String, CartVO> service2;
	
	//로그인 화면 으로 가기//////////////////////////////////////////////////
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "loginregister");
		mv.setViewName("main");
		return mv;
	}
	//로그인 화면으로 이동///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	
	//아이디 중복 체크//////////////////////////////////////////////////
	@RequestMapping("/idcheck.mc")////////////아이디 중복검사 
	@ResponseBody
	public int IdCheck(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userid = request.getParameter("user_id");
		System.out.println(userid);
		
		UserVO dbuser = null;
		try {
			dbuser = service.get(userid);
			System.out.println("is"  + dbuser);
			if(dbuser == null)
				return 0; // 아이디가 중복 되면 취소 
			else {
				return 1; //여기서 아이디가 중복 되지 않을 때
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	//아이디 중복 체크///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	
	
	//////로그인 ////////////////////////////////////////
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(
			HttpServletRequest request) throws InterruptedException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd);
		ModelAndView mv = new ModelAndView();
		
		String tests[] = new String[2];
		tests[0] = "t1";
		tests[1] = "t2";
		
		UserVO dbuser = null;
		
		try {
			dbuser = service.get(id);
			if(dbuser.getUserpwd().equals(pwd)) {
				mv.addObject("center", "ok");
				HttpSession session 
				= request.getSession();
				session.setAttribute("loginid", id);
				
			}else {
				mv.addObject("center", "fail");
			}
		} catch (Exception e) {
			mv.addObject("center", "fail");
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/uadd.mc")
	public ModelAndView add(ModelAndView mv) {
		mv.addObject("center", "user/add");
		mv.setViewName("main");
		return mv;
	}
	
	
	//로그인///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	
//	의미 없음
//	@RequestMapping("/uadd.mc")
//	public ModelAndView add(ModelAndView mv) {
//		mv.addObject("center", "user/add");
//		mv.setViewName("main");
//		return mv;
//	}
	
	
	
	
	
	//회원가입 ///////////////////////////////////////////////////////////
	@RequestMapping("/uaddimpl.mc") //// 아이디 등록 
	public String addimpl(UserVO user) {/*
		System.out.println("id 는 " + user.getUserid());
		System.out.println("이름 은 " + user.getUsername());
		System.out.println("pwd는 " + user.getUserpwd());
		System.out.println("useraddr" + user.getUseraddr());
		System.out.println("userphone" + user.getUserphone());
		System.out.println("gender" + user.getGender());
		System.out.println("email" + user.getEmail());
		System.out.println("email" + user.getRanks());
		System.out.println("date is "+ user.getBirth());
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		System.out.println("yes is " + (user.getBirth()).toString());
		Date d = user.getBirth();
		System.out.println(format.format(d));
		String s = format.format(d);
		System.out.println(s);

		*/
		System.out.println(user.getBirth());
		user.setRanks("customer");
		
		try {
			service.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String u =user.getUserid();
		return "redirect:uwelcome.mc?id="+u;	
	}
	
	@RequestMapping("/uwelcome.mc") //// 아이디 환영
		public ModelAndView welcome(ModelAndView mv, String id) {
			mv.addObject("duser", id);
			mv.addObject("center", "user/registersuccess");
			mv.setViewName("main");
		return mv;
	}
	//회원가입///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////

	//로그 아웃/////////////////////////////////
	@RequestMapping("/logout.mc")
	public ModelAndView logout(
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = 
				request.getSession();
		if(session != null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
	}
	//로그아웃///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	
	//회원 탈퇴////////////////////////////////////
	@RequestMapping("/udel.mc")
	public String delete( String id,HttpServletRequest request) {
		
		HttpSession session = 
				request.getSession();
		try {
			service.remove(id);
			if(session != null) {
				session.invalidate(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:bye.mc";
}
	
	
	//탈퇴 마지막 페이지////////////////////////
	@RequestMapping("/bye.mc")
	public ModelAndView move(ModelAndView mv) {
		mv.addObject("center", "bye");
		mv.setViewName("main");
		return mv;
	}
	//탈퇴 마지막 페이지////////////////////////
	//회원 탈퇴///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	
	//회원 정보 수정 화면이동///////////////////////////////////////////////////////////////
	@RequestMapping("/uupdate.mc")
	public ModelAndView update(ModelAndView mv, HttpServletRequest request) {
		HttpSession session= request.getSession();
		
		String id = (String)session.getAttribute("loginid");
		
		try {
			UserVO user = service.get(id);
			StringBuilder sb =new StringBuilder(user.getBirth());
			user.setBirth(sb.substring(0,10));
			System.out.println(user);
			mv.addObject("uuser", user);
			
			mv.addObject("center", "user/update");
			mv.setViewName("main");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	//회원 정보 수정 화면이동///////////////////끝끝끝끝끝끝끝////////////////////////////////////////////
	
	///////////////회원정보 수정////////////////
	@RequestMapping("/uupdateimpl.mc")
	public String updateimpl(UserVO user) {
		
		try {
			service.modify(user);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("이거 안나오면 안됨");
		}
		String id = user.getUserid();
		return "redirect:udetail.mc?id="+id;
	}
	//회원정보 수정////////////////////////
	
	
	/////////////////회원정보 확인 페이지///////////////////////////////////////////////
	@RequestMapping("/udetail.mc")
	public ModelAndView detail(ModelAndView mv,
			String id) {
		UserVO user = null;
		System.out.println(id);

		try {
			user = service.get(id);
			
			mv.addObject("duser", user);
			mv.addObject("center", "user/userdetail");
			mv.setViewName("main");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
////////////////회원정보 확인 페이지////////////////끝끝///////////////////////////////
	
}

