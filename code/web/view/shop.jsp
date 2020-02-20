<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
	function getMin() {
		alert("sadsdasads");
		var min_val = $('.range-price').text();
		var jbSplit = min_val.split('-');
		alert("최저 값은 " + jbSplit);
		var min = jbSplit[1];//값 범위 최저 
		alert(min);
		return min;
	}
	function getMax() {
		alert("sadsdasads");

		var min_val = $('.range-price').text();
		var jbSplit = min_val.split('-');
		alert("최대 값은 " + jbSplit);
		var max = jbSplit[2];// 값 범위 최대 
		alert(max);
		return max;
	}

	$(document).ready(function() { ////// 버튼 안 누르고 서블릿으로 데이터 전송 
		$('#sortByselect').on('change', function() {
			console.log("javascript jquery ");
			var min_val = $('.range-price').text();
			alert(min_val);
			console.log(min_val);
			var jbSplit = min_val.split('-');
			alert("최저 값은 " + jbSplit);
			console.log(jbSplit[0]);
			console.log(jbSplit[1]);
			console.log(jbSplit[2]);
			if(jbSplit[2] == undefined){
				alert("세번 째 값은 undefined 이다.!!");
				var min = jbSplit[0];
				var max = jbSplit[1];
				min = min.split(' ');
				console.log(min[1]);
				$('#custId1').attr("value", min[1]); /////////////////////원화가격 최저 
				$('#custId2').attr("value", max);
				this.form.submit();
			}
			else{
				alert("");
				var min = jbSplit[1];
				var max = jbSplit[2];// 값 범위 최대 
				$('#custId1').attr("value", min); /////////////////////원화가격 최저 
				$('#custId2').attr("value", max);
				this.form.submit();
			}
			alert("!!");
			
		});
		/*	  $("select").change(function(){
		 console.log("haha");
		 //$("form").submit();
		 });*/
	});

	//이전 버튼 이벤트

	function fn_prev(page, range, rangeSize) {

		var page = ((range - 2) * rangeSize) + 1;

		var range = range - 1;

		var url = "${pageContext.request.contextPath}/board/getBoardList";

		url = url + "?page=" + page;

		url = url + "&range=" + range;

		location.href = url;

	}

	//페이지 번호 클릭

	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "shop.mc";
		
		url = url + "?page=" + page;
		
		url = url + "&range=" + range;
			
		console.log(url);
		
		location.href = url;
	}	

	//다음 버튼 이벤트

	function fn_next(page, range, rangeSize) {

		var page = parseInt((range * rangeSize)) + 1;

		var range = parseInt(range) + 1;

		var url = "${pageContext.request.contextPath}/board/getBoardList";

		url = url + "?page=" + page;

		url = url + "&range=" + range;

		location.href = url;

	}
</script>

<!-- ##### Breadcumb Area Start ##### -->
<div class="breadcumb_area bg-img"
	style="background-image: url(img/bg-img/breadcumb.jpg);">
	<div class="container h-100">
		<div class="row h-100 align-items-center">
			<div class="col-12">
				<div class="page-title text-center">
					<h2>Laptop</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ##### Breadcumb Area End ##### -->

<!-- ##### Shop Grid Area Start ##### -->
<section class="shop_grid_area section-padding-80">
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-4 col-lg-3">
				<div class="shop_sidebar_area">

					<!-- ##### Single Widget ##### -->
					<div class="widget catagory mb-50">
						<!-- Widget Title -->
						<h6 class="widget-title mb-30">Catagories</h6>

						<!--  Catagories  -->
						<div class="catagories-menu">
							<ul id="menu-content2" class="menu-content collapse show">
								<!-- Single Item -->
								<li data-toggle="collapse" data-target="#clothing"><a
									href="#">Brand</a>
									<ul class="sub-menu collapse show" id="clothing">
										<c:choose>
											<c:when test="${speccpu == null}">
												<li><a href="shop.mc?brand=SAMSUNG&page=1&range=1">SAMSUNG</a></li>
												<li><a href="shop.mc?brand=ASUS&page=1&range=1">ASUS</a></li>
												<li><a href="shop.mc?brand=HP&page=1&range=1">HP</a></li>
												<li><a href="shop.mc?brand=DELL&page=1&range=1">DELL</a></li>
												<li><a href="shop.mc?brand=LG&page=1&range=1">LG</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="shop.mc?speccpu=I9&page=1&range=1">I9</a></li>
												<li><a href="shop.mc?speccpu=I7&page=1&range=1">I7</a></li>
												<li><a href="shop.mc?speccpu=I5&page=1&range=1">I5</a></li>
												<li><a href="shop.mc?speccpu=I3&page=1&range=1">I3</a></li>
												<li><a href="shop.mc?speccpu=RYZEN">RYZEN</a></li>
											</c:otherwise>
										</c:choose>
									</ul></li>
								<!-- Single Item -->
							</ul>
						</div>
					</div>

					<!-- ##### Single Widget ##### -->
					<div class="widget price mb-50">
						<!-- Widget Title -->
						<h6 class="widget-title mb-30">Filter by</h6>
						<!-- Widget Title 2 -->
						<p class="widget-title2 mb-30">Price</p>

						<div class="widget-desc">
							<div class="slider-range"><!-- 아래에  추가해라   -->
								<div data-min="300000" data-max="5000000" data-unit=""
									class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"
									data-value-min="300000" data-value-max="5000000"
									data-label-result="Range:">
									<div class="ui-slider-range ui-widget-header ui-corner-all"></div>
									<span class="ui-slider-handle ui-state-default ui-corner-all"
										tabindex="0"></span> <span
										class="ui-slider-handle ui-state-default ui-corner-all"
										tabindex="0"></span>
								</div>
								<div class="range-price">원화범위-300000-5000000</div>
							</div>
						</div>
					</div>

					<!-- ##### Single Widget ##### -->

					<!-- ##### Single Widget ##### -->
				</div>
			</div>

			<div class="col-12 col-md-8 col-lg-9">
				<div class="shop_grid_product_area">

					<div class="row">
						<div class="col-12">
							<div
								class="product-topbar d-flex align-items-center justify-content-between">
								<!-- Total Products -->
								<div class="total-products">
									<p>
										<span>${psize } </span> products found
									</p>
								</div>
								<!-- Sorting -->
								<div class="product-sorting d-flex">
									<c:choose>
										<c:when test="${speccpu == null }">
											<p>Brand Sort by:</p>
											<form id="brand" action="shop.mc?brand=${brand }&page=${pagination.page }&range=${pagination.range }"
												method="get">
												<!--  -->
												<input type="hidden" id="custId1" name="min" value=getMin()> 
												<input type="hidden" id="custId2" name="max" value=getMax()> 
												<input type="hidden" value="${brand }" name="brand" /> 
												<input type="hidden" value="${pagination.page }" name="page" /> 
												<input type="hidden" value="${pagination.range }" name="range" /> 
												<select name="select" id="sortByselect" onchange="this.form.submit()">
													<!-- -->
													<option value="Hrated">Highest Rated</option>
													<option value="newest">Newest</option>
													<option value="priceHL">Price: $$ - $</option>
													<option value="priceLH">Price: $ - $$</option>
												</select> <input type="submit" class="d-none" value="">
											</form>
										</c:when>
										<c:otherwise>
											<p>CPU Sort by:</p>
											<form id="cpu" action="shop.mc?speccpu=${speccpu }"
												method="get">
												<!--  -->
												<input type="hidden" id="custId1" name="min" value="getMin()">
												<input type="hidden" id="custId2" name="max" value="getMax()"> 
												<input type="hidden" value="${speccpu }" name="speccpu" />
												<input type="hidden" value="${pagination.page }" name="page" /> 
												<input type="hidden" value="${pagination.range }" name="range" /> 
												<!-- 숨겨진 값을 서블릿에 넘긴다.  -->
												<!--<select name="select" id="sortByselect" onchange="this.form.submit()">  -->
												<select name="select" id="sortByselect">
													<option value="Hrated">Highest Rated</option>
													<option value="newest">Newest</option>
													<option value="priceHL">Price: $$ - $</option>
													<option value="priceLH">Price: $ - $$</option>
												</select> <input type="submit" class="d-none" value="">
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
					<div class="row">


						<c:choose>
							<c:when test="${shopcenter == null }">
								<jsp:include page="shopcenter.jsp" />
							</c:when>
							<c:otherwise>
								<jsp:include page="${shopcenter }.jsp" />
							</c:otherwise>
						</c:choose>


					</div>

				</div>

				<!-- pagination{s} -->

				<div id="paginationBox">
					<ul class="pagination">
						<c:if test="${pagination.prev}">
							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
						</c:if>
						<c:forEach begin="${pagination.startPage}"
							end="${pagination.endPage}" var="idx">
							<li
								class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
								class="page-link" href="#"
								onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
									${idx} </a></li>
						</c:forEach>
						<c:if test="${pagination.next}">
							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!-- pagination{e} -->


				<!-- Pagination -->
			</div>
		</div>
	</div>
</section>
<!-- ##### Shop Grid Area End ##### -->

<!-- ##### Footer Area End ##### -->
