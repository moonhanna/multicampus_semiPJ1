package sdr.controller;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sdr.frame.Service;
import sdr.vo.ProductVO;
import sdr.others.*;

@Controller
public class LaptopController {
	/*
	 * LaptopController ============= 메인 컨트롤는 메인 페이지, 상세 페이지를 담당한다.
	 * 
	 * 
	 */
	@Resource(name = "productservice")
	Service<String, ProductVO> service;

	@RequestMapping("/main.mc")
	public ModelAndView main() {
		System.out.println("메인 올라왔다. ");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	/*
	 * @RequestMapping("/productdetail.mc") public ModelAndView
	 * login(HttpServletResponse response) { ModelAndView mv = new ModelAndView();
	 * mv.addObject(attributeValue); mv.addObject("center", "productdetail");
	 * mv.setViewName("main"); return mv; }
	 */

	@RequestMapping("/popular.mc") ////////// 메인 화면에 5개의 인기상품 뽑기
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<ProductVO> list = null;
		try {
			list = service.getRank();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();

		/*
		 * String prodname; String brand; int price; String speccpu; String specram;
		 * String specstorage; String specsize; String specimg; int stock;
		 */
		int a = 0;
		// 가격, 상품명 , 이미지 이름 <img src="
		for (ProductVO u : list) {
			JSONObject jo = new JSONObject();
			jo.put("prodname", u.getProdname());
			jo.put("price", u.getPrice());
			jo.put("specimg", u.getSpecimg());
			System.out.println(u.getSpecimg());
			ja.add(jo);
			a++;
			if (a == 5)
				break;
		}
		out.print(ja.toJSONString());
		out.close();
	}
	public void MySortPrice(ArrayList<ProductVO> list, int order) {
		//		//order 0 은 내림차순 1은 오름차순
		if(order == 1) {
			Collections.sort(list, new Comparator<ProductVO>() {/// 가격 오름차
				@Override
				public int compare(ProductVO z1, ProductVO z2) {
					if (z1.getPrice() > z2.getPrice())
						return 1;
					if (z1.getPrice() < z2.getPrice())
						return -1;
					return 0;
				}
			});
		}
		if(order == 0) {
			Collections.sort(list, new Comparator<ProductVO>() {/// 가격 오름차
				@Override
				public int compare(ProductVO z1, ProductVO z2) {
					if (z1.getPrice() < z2.getPrice())
						return 1;
					if (z1.getPrice() > z2.getPrice())
						return -1;
					return 0;
				}
			});
		}

	}
	public void MySortDate(ArrayList<ProductVO> list) {
		Collections.sort(list, new Comparator<ProductVO>() {
			@Override
			public int compare(ProductVO z1, ProductVO z2) {
				System.out.println(z1.getProddate());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date1;
				Date date2;
				int totalDate1 = 0;
				int totalDate2 = 0;
				try {
					date1 = dateFormat.parse(z1.getProddate());
					date2 = dateFormat.parse(z2.getProddate());
					String strDate1 = dateFormat.format(date1);
					String strDate2 = dateFormat.format(date2);
					String[] tmp1 = strDate1.split("-");
					String[] tmp2 = strDate2.split("-");
					if (tmp1[2].equals(tmp2[2])) {
						System.out.println(tmp1[2]);
						System.out.println(tmp2[2]);
					}
					totalDate1 = Integer.parseInt(tmp1[0]) * 10000;
					totalDate2 = Integer.parseInt(tmp2[0]) * 10000;

					totalDate1 += Integer.parseInt(tmp1[1]) * 100;
					totalDate2 += Integer.parseInt(tmp2[1]) * 100;

					totalDate1 += Integer.parseInt(tmp1[2]) * 100;
					totalDate2 += Integer.parseInt(tmp2[2]) * 100;
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (totalDate1 > totalDate2)
					return 1;
				if (totalDate1 < totalDate2)
					return -1;
				return 0;
			}
		});

	}

	@RequestMapping("/shop.mc") /////////////// 이 함수는 shop 페이지( 전체 상품 로딩되는 페이지) 로 넘어간다.
	@ResponseBody
	public ModelAndView getShop(ModelAndView mv, HttpServletRequest request) throws ServletException, IOException {
		int min = 400000, max = 5000000;
		String min_one = request.getParameter("min");
		String max_one = request.getParameter("max");
		if(min_one != null && max_one != null) {
			System.out.println(max_one);
			if(max_one.charAt(0) == ' ') {
				System.out.println();
				String tmp = max_one.substring(1);
				min = Integer.parseInt(request.getParameter("min"));
				max = Integer.parseInt(tmp);
			}else {
				if(min_one.trim() != null)
					min = Integer.parseInt(request.getParameter("min"));
				if(max_one.trim() != null )
					max = Integer.parseInt(request.getParameter("max"));
			}

		}
		/*
		System.out.println(min_one);
		System.out.println(max_one);
		if(min_one != null) {
			String max_second = max_one.substring(1);

			if(min_one.trim() != null)
				min = Integer.parseInt(request.getParameter("min"));
			if(max_second.trim() != null )
				max = Integer.parseInt(request.getParameter("max"));
		}*/
		
		int page = Integer.parseInt(request.getParameter("page"));
		int range = Integer.parseInt(request.getParameter("range"));
		System.out.println("min은 " + min + "max 는 " + max);
		System.out.println("page는  " + page);
		System.out.println("range 는" + range);
		String brand = request.getParameter("brand");
		System.out.println("brand는 :" + brand);
		String speccpu = request.getParameter("speccpu");
		System.out.println("spec cpu는 : " + speccpu);

		String select = request.getParameter("select");
		System.out.println("select 는" + select);

		Pagination pagination = new Pagination();
		
		/*
		 * <option value="Hrated">Highest Rated</option> <option
		 * value="newest">Newest</option> <option value="priceHL">Price: $$ - $</option>
		 * <option value="priceLH">Price: $ - $$</option>
		 */

		if (speccpu == null)
			System.out.println("speccpu  null!!!!");
		if (brand == null)
			System.out.println("brand null!!!!");

		ArrayList<ProductVO> list = new ArrayList<>();
		ArrayList<ProductVO> conditioned = null;
		
		/*
		  for(ProductVO u: list) { 
			  if(u.getPrice()> min && u.getPrice() < max)
				  conditioned.add(u);
		  
		  }
		 */	
		try {
			if (speccpu != null) {//// cpu 일때
				ArrayList<ProductVO> list2 = null;
				list2 = service.getSpeccpu(speccpu);
				System.out.println(list2.size());
				  for(ProductVO u: list2) { 
					  if(u.getPrice()> min && u.getPrice() < max) {
						  list.add(u);
						  System.out.println(u.getPrice());
					  }
				  }

				
				if (select != null) {
					  if(select.equals("Hrated")) {
						  
					  }else if(select.equals("newest")) {
						  MySortDate(list);
						  for(ProductVO u: list) {
							  u.getPrice();
						  }
						  System.out.println("haha");
					  }else if(select.equals("priceHL")) {
						  MySortPrice(list, 0);
					  }else if(select.equals("priceLH")) {
						  MySortPrice(list,1);
					  }
				}
				
				pagination.pageInfo(page, range, list.size());
				//30 ~ 40 
				// range ~ range+list.size()
				mv.addObject("pagination", pagination);
				System.out.println("cpu입니다. ");
				mv.addObject("speccpu", speccpu);
				mv.addObject("plist", list);
				

				if(list.size() < (page+1) * pagination.getListSize() ) {
					mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
					mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), list.size()-1));
				}else if( list.size() >= pagination.getListSize()){
					
					mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
					mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), page*pagination.getListSize()-1));
				}
				mv.addObject("center", "shop");
				mv.addObject("shopcenter", "shopcenter");
				mv.setViewName("main");
				return mv;
			}

			/*
			if (speccpu != null) {//// cpu 일때
				list = service.getSpeccpu(speccpu);
				if (select != null) {
					  if(select.equals("Hrated")) {
						  
					  }else if(select.equals("newest")) {
						  MySortDate(list);
						  for(ProductVO u: list) {
							  u.getPrice();
						  }
						  System.out.println("haha");
					  }else if(select.equals("priceHL")) {
						  MySortPrice(list, 0);
					  }else if(select.equals("priceLH")) {
						  MySortPrice(list,1);
					  }
				}
				
				pagination.pageInfo(page, range, list.size());
				//30 ~ 40 
				// range ~ range+list.size()
				mv.addObject("pagination", pagination);
				System.out.println("cpu입니다. ");
				mv.addObject("speccpu", speccpu);
				mv.addObject("plist", list);
				
				if(list.size() < (page+1) * pagination.getListSize() ) {
					mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
					mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), list.size()-1));
				}else if( list.size() >= pagination.getListSize()){
					
					mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
					mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), page*pagination.getListSize()-1));
				}
				mv.addObject("center", "shop");
				mv.addObject("shopcenter", "shopcenter");
				mv.setViewName("main");
				
				return mv;
			}*/
			
			/*
			ArrayList<ProductVO> list2 = null;
			list2 = service.getSpeccpu(speccpu);
			System.out.println(list2.size());
			  for(ProductVO u: list2) { 
				  if(u.getPrice()> min && u.getPrice() < max) {
					  list.add(u);
					  System.out.println(u.getPrice());
				  }
			  }
*/	
			if (brand != null) {
				ArrayList<ProductVO> list2 = null;
				list2 = service.getBrand(brand);
				System.out.println("브랜드 입니다. " + brand);
				  for(ProductVO u: list2) { 
					  if(u.getPrice()> min && u.getPrice() < max) {
						  list.add(u);
						  System.out.println(u.getPrice());
					  }
				  }

				
				
			} else if (brand == null) {
				ArrayList<ProductVO> list2 = null;
				list2 = service.getBrand("SAMSUNG");
				System.out.println("삼성입니다.");
				  for(ProductVO u: list2) { 
					  if(u.getPrice()> min && u.getPrice() < max) {
						  list.add(u);
						  System.out.println(u.getPrice());
					  }
				  }
			} 
			
			
			
			if (select != null) {
				  if(select.equals("Hrated")) {
					  
				  }else if(select.equals("newest")) {
					  MySortDate(list);
					  System.out.println("haha");
				  }else if(select.equals("priceHL")) {
					  MySortPrice(list, 0);
				  }else if(select.equals("priceLH")) {
					  MySortPrice(list,1);
				  }
			}

			pagination.pageInfo(page, range, list.size());
			mv.addObject("pagination", pagination);
			System.out.println("cpu입니다. ");
			mv.addObject("brand", brand);
			//mv.addObject("psize", list.size());
			//mv.addObject("plist", list);
			System.out.println("page는 " + page + " pagination은 " + pagination.getListSize() + " list 사이즈는 : " + (list.size()-1));
			if(list.size() == 0) {
				mv.addObject("center", "shop");
				mv.addObject("shopcenter", "shopcenter");
				mv.setViewName("main");
			}
			if(list.size() < (page+1) * pagination.getListSize() ) {
				mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
				mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), list.size()-1));
			}else if( list.size() >= pagination.getListSize()){
				
				mv.addObject("psize", list.size());//range = 1, page = 2   pagination.listSize = 10,,, 
				mv.addObject("plist", list.subList((page-1)*(pagination.getListSize()), page*pagination.getListSize()-1));
			}

			mv.addObject("center", "shop");
			mv.addObject("shopcenter", "shopcenter");
			mv.setViewName("main");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/getFilter.mc") /////////////////// 필터를 담당하는 함수
	@ResponseBody
	public void getBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		String json = request.getParameter("data1");
		System.out.println("json is :" + json);
		String sortBy = request.getParameter("sortBy");
		System.out.println("getFilter시작");
		System.out.println(sortBy);

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(json);
			System.out.println("parsed value is" + jsonObject);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String brand = (String) jsonObject.get("0");
		String temp = (String) jsonObject.get("1");
		int price;
		price = Integer.parseInt(temp);
		String cpu = (String) jsonObject.get("2");
		String memory = (String) jsonObject.get("3");
		String disk = (String) jsonObject.get("4");
		String monitor = (String) jsonObject.get("5");
		/*
		 * System.out.println(brand); System.out.println(price);
		 * System.out.println(cpu); System.out.println(memory);
		 * System.out.println(disk); System.out.println(monitor);
		 * System.out.println(json);
		 * 
		 */
		PrintWriter out = response.getWriter();
		ArrayList<ProductVO> list = null;
		System.out.println("getFilter executed");
		try {
			list = service.getBrand(brand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();

		if (sortBy.equals("\"price\"")) {

			Collections.sort(list, new Comparator<ProductVO>() {/// 가격 오름차
				@Override
				public int compare(ProductVO z1, ProductVO z2) {
					if (z1.getPrice() > z2.getPrice())
						return 1;
					if (z1.getPrice() < z2.getPrice())
						return -1;
					return 0;
				}
			});
		} else if (sortBy.equals("\"date\"")) {
			System.out.println("sort by date");

			Collections.sort(list, new Comparator<ProductVO>() {
				@Override
				public int compare(ProductVO z1, ProductVO z2) {
					System.out.println(z1.getProddate());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date1;
					Date date2;
					int totalDate1 = 0;
					int totalDate2 = 0;
					try {
						date1 = dateFormat.parse(z1.getProddate());
						date2 = dateFormat.parse(z2.getProddate());
						String strDate1 = dateFormat.format(date1);
						String strDate2 = dateFormat.format(date2);
						String[] tmp1 = strDate1.split("-");
						String[] tmp2 = strDate2.split("-");
						if (tmp1[2].equals(tmp2[2])) {
							System.out.println(tmp1[2]);
							System.out.println(tmp2[2]);
						}
						totalDate1 = Integer.parseInt(tmp1[0]) * 10000;
						totalDate2 = Integer.parseInt(tmp2[0]) * 10000;

						totalDate1 += Integer.parseInt(tmp1[1]) * 100;
						totalDate2 += Integer.parseInt(tmp2[1]) * 100;

						totalDate1 += Integer.parseInt(tmp1[2]) * 100;
						totalDate2 += Integer.parseInt(tmp2[2]) * 100;
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (totalDate1 > totalDate2)
						return 1;
					if (totalDate1 < totalDate2)
						return -1;
					return 0;
				}
			});
			System.out.println(list.size());
			for (ProductVO u : list) {
				System.out.println("haha date is " + u.getProddate());
			}
		}

		System.out.println("list size is " + list.size());
		for (ProductVO u : list) {
			System.out.println("for loop executed");
			JSONObject jo = new JSONObject();
			jo.put("prodname", u.getProdname());
			jo.put("brand", u.getBrand());
			jo.put("price", u.getPrice());
			jo.put("speccpu", u.getSpeccpu());
			jo.put("specram", u.getSpecram());
			jo.put("specstorage", u.getSpecstorage());
			jo.put("specsize", u.getSpecsize());
			jo.put("specimg", u.getSpecimg());
			jo.put("stock", u.getStock());
			jo.put("proddate", u.getProddate());

			if (brand.equals(u.getBrand()) && price > u.getPrice() && cpu.equals(u.getSpeccpu())
					&& memory.equals(u.getSpecram()) && disk.equals(u.getSpecstorage())
					&& monitor.equals(u.getSpecsize())) {
				ja.add(jo);
				System.out.println("existed!!!!!!");
				System.out.println(sortBy);
			}
		}
		out.print(ja.toJSONString());
		out.close();
	}

	@RequestMapping("/getProduct.mc") /////////////// 아래 함수가 특정 노트북 상세 페이지로 넘어가는 컨트롤러
	@ResponseBody
	public ModelAndView getProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		ModelAndView mv = new ModelAndView();

		String prodname = request.getParameter("prodname");
		String specimg = request.getParameter("specimg");
		String tmp = request.getParameter("price");
		int price = Integer.parseInt(tmp);
		System.out.println(prodname + "and  " + specimg);

		/*
		 * System.out.println("getProduct loaded");
		 * 
		 * PrintWriter out = response.getWriter(); ArrayList<ProductVO> list = null;
		 * 
		 * try { list = service.get(); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * JSONArray ja = new JSONArray(); for(ProductVO u:list) { JSONObject jo = new
		 * JSONObject(); jo.put("prodname", u.getProdname()); jo.put("brand",
		 * u.getBrand()); jo.put("price", u.getPrice()); jo.put("speccpu",
		 * u.getSpeccpu()); jo.put("specram", u.getSpecram()); jo.put("specstorage",
		 * u.getSpecstorage()); jo.put("specsize", u.getSpecsize()); jo.put("specimg",
		 * u.getSpecimg()); jo.put("stock", u.getStock());
		 * 
		 * ja.add(jo); } out.print(ja.toJSONString()); out.close();
		 */
		System.out.println(specimg);
		mv.addObject("prodname", prodname);
		mv.addObject("specimg", specimg);
		mv.addObject("price", price);
		mv.addObject("center", "detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/getSearch.mc") /////////////// 아래 함수가 특정 노트북 상세 페이지로 넘어가는 컨트롤러
	@ResponseBody
	public ModelAndView getSearch(HttpServletRequest httpServletRequest) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		String searched = httpServletRequest.getParameter("search");/// 포스트 방식으로 담기
		System.out.println(searched);
		ProductVO list = null;
		try {
			list = service.get(searched);


		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list==null) {
			mv.addObject("searched", "찾으시는 상품이 없습니다.");
			mv.setViewName("main");
			System.out.println("가자");
			return mv;
		}
		else {
			mv.addObject("searched", "yes");
			mv.addObject("prodname", list.getProdname());
			mv.addObject("specimg", list.getSpecimg());
			mv.addObject("price", list.getPrice());
			mv.addObject("center", "detail");
			mv.setViewName("main");
		}
		return mv;
	}

	@RequestMapping("/blog.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "single-blog");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/contact.mc")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "contact");
		mv.setViewName("main");
		return mv;
	}
}
