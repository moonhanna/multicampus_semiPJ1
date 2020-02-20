package sdr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.BoardVO;
import sdr.vo.ProductVO;

@Controller
public class ProductDetailController {
/* 
 * ProductDetailController
 * 제품상세 페이지를 담당한다.
 * 게시판 페이지를 토글로 불러오는것 까지 담당. 
 */
	
	@Resource(name="productservice")
	Service<String, ProductVO> service;
	

	@Resource(name="boardservice")
	Service<String, BoardVO> service2;

	// 제품 상세 페이지 + 보드 불러오기 //
	// select * from where = ? 을 적용하기 위해 select 가  arraylist로 적용//

	@RequestMapping("/productdetail.mc")
	@ResponseBody
	public ModelAndView getProduct(String prodname, ModelAndView mv) throws ServletException,IOException {
		System.out.println("print");
		ProductVO vo = null;
		ArrayList<BoardVO> voq = null;
		ArrayList<BoardVO> vor = null;
		int sum=0;
		int average=0;
		
		try {
			vo = service.get(prodname);
			voq = service2.getQA(prodname);
			vor = service2.getRV(prodname);
			
		for(BoardVO u : voq) {
		    String myDate = u.getBdate();
		    String[] myDateArr = myDate.split(" ");
		    u.setBdate(myDateArr[0]);
		}
		for(BoardVO u2 : vor) {
		    String myDate = u2.getBdate();
		    String[] myDateArr = myDate.split(" ");
		    u2.setBdate(myDateArr[0]);
		    sum += u2.getBstar();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("제품정보 "+vo);
        System.out.println("질문 게시판 데이터 "+voq);
        System.out.println("리뷰 게시판 데이터 "+vor);
        int voqs = voq.size();
        int vors = vor.size();
        if(vors != 0) {
        	average = sum/vors;
        	}
        	else {
        	average = 1;
        	};
        System.out.println("질문게시판 데이터 개수 :"+voqs);
        System.out.println("리뷰게시판 데이터 개수 :"+vors);
        
		mv.addObject("center", "productdetail");
		mv.addObject("productvo", vo);
		mv.addObject("boardvoq", voq);
		mv.addObject("boardvor", vor);
		mv.addObject("average", average);
		mv.addObject("voqs", voqs);
		mv.addObject("vors", vors);
		
		
		mv.setViewName("main");
		return mv;
	}
	
	///// 게시판 글 추가 기능 만들기  , Form 으로 데이터전송. /////
	
	
	@RequestMapping("/boardaddimpl.mc")
	public String boardAddImpl(BoardVO board, String bdatetemp) {
		System.out.println("addimpl start");
		System.out.println(bdatetemp);
		String prodname = board.getProdname();
		String[] btemp = bdatetemp.split(" ");
		btemp[1] = "12";
		String bdate = btemp[3]+"/"+btemp[1]+"/"+btemp[2];
		System.out.println(bdate);
		board.setBdate(bdate);
		try {
			System.out.println(board);
			service2.register(board);
			System.out.println("board registered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productdetail.mc?prodname="+prodname;
	}
	
	
	//게시판 Delete 함수가 실행되면 여기로옴,AJAX 로 데이터 전송 // 
	
	@RequestMapping("/boarddelete.mc")
	@ResponseBody
	public ModelAndView delete(HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView();
		String boardno = request.getParameter("boardno");		
		String prodname = request.getParameter("prodname");
		System.out.println(boardno);
		System.out.println(prodname);
		try {
			System.out.println(boardno+"removed");
			service2.removeBoard(Integer.parseInt(boardno));
			mv.addObject("center","productdetail.mc?prodname="+prodname);
			mv.setViewName("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	// 게시판 업데이트 form 형식으로 받기 // 
	
	
	@RequestMapping("/boardupdateimpl.mc")
	public String boardUpdateImpl(BoardVO board) {
		System.out.println("boardupdate start");
		System.out.println(board.getBcontent());
		System.out.println(board.getBoardno());
		System.out.println(board.getBstar());
		String prodname = board.getProdname();
		try {
			service2.modify(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productdetail.mc?prodname="+prodname;
	}
	
	
}
