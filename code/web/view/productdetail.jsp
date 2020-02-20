<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!--  제품 상세 페이지  
2019-12-17
1. center -> productdetail 로 넘어올 떄 prodname 을 받아서 넘어오고 , productvo 와 boardvo로 데이터 사용 중
2. 게시판 crud 구현해야함.  
-->
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Product_deatil page</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="css_productdetail/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet"
	href="css_productdetail/slick.css" />
<link type="text/css" rel="stylesheet"
	href="css_productdetail/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet"
	href="css_productdetail/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="css_productdetail/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="css_productdetail/style.css" />

<!--  data toggle css start -->

<link rel="icon" type="image/png" href="images_board/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor_board/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts_board/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor_board/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor_board/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor_board/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="css_board/util.css">
<link rel="stylesheet" type="text/css" href="css_board/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!--  data toggle css end -->



<script>
$(document).ready(function(){

});

	//  board scroll function start //
	$('.js-pscroll').each(function() {
		var ps = new PerfectScrollbar(this);

		$(window).on('resize', function() {
			ps.update();
		})
	});
	//  board scroll function end //
	
	

	var sysdate = new Date();
	// Questions 등록하기  //
	function QuestionInsert(){
		var results = '';
		results += "<div class=form-group>"
		results += '<form action="boardaddimpl.mc" method="post">'
		results += "<label for='comment'><h3>하단에 내용을 입력해주세요</h3></label>"
		results += "<input type='hidden' name='boardno' value='0'>"
		results += "<input type='text' name= 'bcontent' placeholder= '내용을입력해주세요' style ='width:100%; height:50px; font-size:17px; outline-style:solid;'>"
		results += "<input type='hidden' name='userid' value='${loginid }'>"
		results += "<input type='hidden' name='bdatetemp' value='"+sysdate+"'>"
		results += "<input type='hidden' name='prodname' value='${productvo.prodname }'>"
		results += "<input type='hidden' name='btype' value='QA'>"
		results += "<input type='hidden' name='bstar' value='0'>"
		results += '<input type="submit" value="등록하기" style="font-size:17px;">'
		results += '</form></div>'
		$('#question_insert').append(results);
	}
	function QuestionUpdate(boardno,bcontent){
		var results = '';
		this.bcontent = bcontent;
		this.boardno = boardno;
		alert(bcontent);
		alert(boardno);
		
		results += "<div class=form-group style>"
		results += '<form action="boardupdateimpl.mc" method="post">'
		results += "<label for='comment'><h3>하단에 수정할 내용을 입력해주세요</h3></label>"
		results += "<input type='hidden' name='boardno' value='"+boardno+"'>"
		results += "<input type='text' name= 'bcontent' placeholder= '"+bcontent+"'style ='width:100%; height:50px; font-size:17px; outline-style: solid;'>"
		results += "<input type='hidden' name='userid' value='${loginid }'>"
		results += "<input type='hidden' name='bdatetemp' value='"+sysdate+"'>"
		results += "<input type='hidden' name='prodname' value='${productvo.prodname }'>"
		results += "<input type='hidden' name='btype' value='QA'>"
		results += "<input type='hidden' name='bstar' value='0'>" 
		results += '<input type="submit" value="등록하기" style="font-size:17px;">'
		results += '</form></div>'
		
		$('#question_update').append(results);
	}
	// Questions 등록 기능 //
	// Review 등록 기능 //
	function ReviewInsert(){
		var results = '';
		results += "<div class=form-group style>"
		results += '<form action="boardaddimpl.mc" method="post">'
		results += "<label for='comment'><h3>하단에 내용을 입력해주세요</h3></label>"
		results += "<input type='hidden' name='boardno' value='0'>"
		results += "<input type='text' name= 'bcontent' placeholder= '내용을입력해주세요' style ='width:100%; height:50px; font-size:17px; outline-style: solid;'>"
		results += "<input type='hidden' name='userid' value='${loginid }'>"
		results += "<input type='hidden' name='bdatetemp' value='"+sysdate+"'>"
		results += "<input type='hidden' name='prodname' value='${productvo.prodname }'>"
		results += "<input type='hidden' name='btype' value='RV'>"
		results += "<h4>평점:0~5 사이로 입력해주세요</h4><input type='number' name='bstar' min='0' max='5' style ='font-size:15px; outline-style:solid;'>" 
		results += '<input type="submit" value="등록하기" style="font-size:17px;">'
		results += '</form></div>'
		$('#review_insert').append(results);
	}
	// Review 등록 기능 //
	
	function ReviewUpdate(boardno,bcontent){
		var results = '';
		this.bcontent = bcontent;
		this.boardno = boardno;
		alert(bcontent);
		alert(boardno);
		
		results += "<div class=form-group style>"
		results += '<form action="boardupdateimpl.mc" method="post">'
		results += "<label for='comment'><h3>하단에 수정할 내용을 입력해주세요</h3></label>"
		results += "<input type='hidden' name='boardno' value='"+boardno+"'>"
		results += "<input type='text' name= 'bcontent' placeholder= '"+bcontent+"'style ='width:100%; height:50px; font-size:17px; outline-style: solid;'>"
		results += "<input type='hidden' name='userid' value='${loginid }'>"
		results += "<input type='hidden' name='bdatetemp' value='"+sysdate+"'>"
		results += "<input type='hidden' name='prodname' value='${productvo.prodname }'>"
		results += "<input type='hidden' name='btype' value='RV'>"
		results += "<h4>평점:0~5 사이로 입력해주세요</h4><input type='number' name='bstar' min='0' max='5' style ='font-size:15px; outline-style:solid;'>" 
		results += '<input type="submit" value="등록하기" style="font-size:17px;">'
		results += '</form></div>'
		
		$('#review_update').append(results);
	}
	
</script>


<!--  board script start-->
<script src="vendor_board/jquery/jquery-3.2.1.min.js"></script>

<script src="vendor_board/bootstrap/js/popper.js"></script>
<script src="vendor_board/bootstrap/js/bootstrap.min.js"></script>

<script src="vendor_board/select2/select2.min.js"></script>

<script src="vendor_board/perfect-scrollbar/perfect-scrollbar.min.js"></script>



<script src="js_board/main.js"></script>


</head>
<body>


	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row"></div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- Product main img -->
				<div class="col-md-5 col-md-push-2">
					<div id="product-main-img">
						<div class="product-preview">
							<img src="view/img/${productvo.specimg }" alt="">
						</div>

						<div class="product-preview">
							<img src="#" alt="">
						</div>

						<div class="product-preview">
							<img src="#" alt="">
						</div>

						<div class="product-preview">
							<img src="#" alt="">
						</div>
					</div>
				</div>
				<!-- /Product main img -->

				<!-- Product thumb imgs -->

				<div class="col-md-2  col-md-pull-5">
					<div id="product-imgs">
						<div class="product-preview">
							<img src="view/img/${productvo.specimg }" alt="">
						<!--	<img src="view/img/${productvo.prodname }_011.jpg" alt="">  -->
						</div>

						<div class="product-preview">
							<img src="view/img/${productvo.specimg }" alt="">
						</div>

						<div class="product-preview">
							<img src="view/img/${productvo.specimg }" alt="">
						</div>
					</div>
				</div>

				<!-- /Product thumb imgs -->

				<!-- Product details -->
				<div class="col-md-5">
					<div class="product-details">
						<!-- Product Name on bottom  START -->
						<h2 class="product-name">${productvo.brand}_${productvo.prodname }</h2>
						<!-- Product Name on bottom  END -->
						<div>
							<!-- Product Review by Star Start 별점 주기 -->
							<div class="product-rating">
							<script type="text/javascript">
                     star = ${average }
                     for (s = 0; s < star; s++)
                     {
                     document.write('<i class="fa fa-star"></i>')
                     }
                     for (o = 0; o < 5 - star; o++)
                     {
                     document.write('<i class="fa fa-star-o"></i>')
                     }
                     </script>
							</div>
							<!-- Product Review by Star END -->
							<a class="review-link" href="#tab1">(${vors })Reviews | Add
								your review</a>
							<!--  add review 누르면 리뷰토글 할 수 있게?-->
						</div>
						<div>
							<h3 class="product-price">
								${productvo.price}
								<del class="product-old-price">${productvo.price }</del>
							</h3>
							<!-- stock 파악하여 재고가 있으면 몇개있는지 표시, stock 값이 0 이면 재고없음 표시 -->
							<c:choose>
							<c:when test="${productvo.stock == 0}">
							<span class="product-available">재고없음</span>
							</c:when>
							<c:otherwise>
							<span class="product-available">재고있음 (${productvo.stock })</span>
							</c:otherwise>
							</c:choose>
						</div>
						<p>
							상품 스펙 - 제품명 : ${productvo.brand}_${productvo.prodname}<br>
							CPU:${productvo.speccpu }<br>
							RAM :${productvo.specram }<br>
							STORAGE:${productvo.specstorage }<br> 
							화면크기 : ${productvo.specsize }인치 
							재고량 : ${productvo.stock }<br>
						</p>

						<!-- ADD to CART and Option 장바구니 추가 및 결제? 옵션선택 등 가능하면 구현-->
						
						<div class="add-to-cart">
							<div class="qty-label">
								<!--  <div class="input-number">-->
									수량 <input type="number"> 
									<!--   <span class="qty-up">+</span> <span
										class="qty-down">-</span>-->
								<!--</div>-->
							</div>
							<c:choose>
							<c:when test = "${loginid != null }">
		<button class="add-to-cart-btn" onclick="addCart('${productvo.prodname }',${productvo.price },'${productvo.specimg }')">
		<i class="fa fa-shopping-cart"></i> 결제
        </button>
							
		<button class="add-to-cart-btn" onclick="addCart('${productvo.prodname }',${productvo.price },'${productvo.specimg }')">
		<i class="fa fa-shopping-cart"></i> 장바구니
        </button>
								
							</c:when>
							<c:otherwise>
							<button class="add-to-cart-btn">
								<i class="fa fa-shopping-cart"></i> 로그인하세요!
							</button>
							</c:otherwise>
							</c:choose>
						</div>

						<ul class="product-btns">
							<li><a href="#"><i class="fa fa-heart-o"></i> 위시리스트 담기</a></li>

						</ul>

						<ul class="product-links">
							<li>제조사:</li>
							<li><a href="#">${productvo.brand }</a></li>
						</ul>

						<ul class="product-links">
							<li>Share:</li>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="fa fa-envelope"></i></a></li>
						</ul>

					</div>
				</div>
				<!-- /Product details -->



<!-- data tab toggle style start-->
<style>
#container {
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

.tab {
	list-style: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
/* Float list items side by side */
.tab li {
	float: left;
}
/* Style links inside the list items */
.tab li a {
	display: inline-block;
	color: #000;
	text-align: center;
	text-decoration: none;
	padding: 14px 16px;
	font-size: 17px;
	transition: 0.3s;
}
/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	color: black;
}

ul.tab li.current {
	color: black;
}

.tabcontent.current {
display: block;
}

</style>
<!-- data tab toggle style END -->


<!------------------------------- Product tab start ------------------------------->
<div class="col-md-12">
	<div id="product-tab">
		<!----------- 토글 탭 네비게이션 영역 (container) ----------->
		<div id="container">
			<ul class="tab">
				<li class="current" data-tab="tab1"><a href="#">Description</a></li>
				<li data-tab="tab2"><a href="#">Q&amp;A (${voqs })</a><br></li>
				<li data-tab="tab3"><a href="#">Reviews(${vors })</a><br></li>
			</ul>
		<!----------- 토글 탭 네비게이션 영역 (container) ----------->

		<!----------- 제품 스펙 상세정보 탭  tab1----------->
			<div id="tab1" class="tabcontent current">
				<h3>상품 스펙정보</h3>
				<p>
				제조사 : ${productvo.brand },
				CPU : ${productvo.speccpu },
				RAM : ${productvo.specram }, 
				용량 : ${productvo.specstorage },
				화면크기 : ${productvo.specsize }
				</p>
			</div>
		<!----------- 제품 스펙 상세정보 탭  ----------->
		
		<!--------  질문 게시판 영역 tab2,question_tab -------->
			<div id="tab2" class="tabcontent">
				<h3>Q&amp;A</h3>
					<div id="questions_tab">
						<div class="limiter">
							<div class="container-table100">
								<div class="wrap-table100">
							<!-------- 질문게시판 기능 만들 영역 시작------ -->
									<div id="question_method" style='text-align: left;'>
									<c:choose>
									<c:when test = "${loginid != null }">
										<button class="btn btn-success" onclick='QuestionInsert();'>문의글 작성</button>													
										<div id = "question_insert"></div>
										<div id = "question_update"></div>	
									</c:when>
									<c:otherwise>
									<p> 로그인하시면 작성할 수 있습니다.</p>
									</c:otherwise>
								</c:choose>			
									</div>
							<!-------- 질문게시판 기능 만들 영역 끝 -------->
							
							<!-------- 질문게시판 테이블 영역  시작   -------->
									<div class="table100 ver2 m-b-110">
									
							<!-------- 질문게시판 테이블 헤드  시작 -------->
										<div class="table100-head">
											<table>
												<thead>
													<tr class="row100 head">
														<th class="cell100 column1">내용</th>
														<th class="cell100 column2">작성자</th>
														<th class="cell100 column3">작성시간</th>
														<th class="cell100 column4">카테고리</th>
														<th class="cell100 column5">답변상황</th>
													</tr>
												</thead>
											</table>
										</div>
							<!-------- 질문게시판 테이블 헤드  끝-------->
										
							<!-------- 질문게시판 테이블 바디 시작-------->
						
					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							<c:forEach var="q" items="${boardvoq }">
								<tr class="row100 body">
								<td class="cell100 column1">${q.bcontent }</td>
								<td class="cell100 column2">${q.userid }</td>
								<td class="cell100 column3">${q.bdate }</td>
								<td class="cell100 column4">질문번호${q.boardno}</td>
								<c:set var="idcheck" value="${loginid }"></c:set>
								<c:choose>
								<c:when test = "${q.userid == idcheck }">
								<td class="cell100 column5"><a href="#" onclick='QuestionUpdate(${q.boardno },"${q.bcontent }");' >수정&#47;</a>
								<a href="#" onclick='QuestionDelete(${q.boardno });'>삭제</a></td>
								
								</c:when>
								<c:when test = "${idcheck == null }">
								<td class="cell100 column5">로그인하세요</td>
								</c:when>
								<c:otherwise>
								<td class="cell100 column5">접수중</td>
								</c:otherwise>
								</c:choose>
								</tr>
							</c:forEach>
						
							</tbody>
						</table>
					</div>
					
							<!-------- 질문게시판 테이블 바디 끝-------->
									</div>
						<!-------- 질문게시판 테이블 영역  끝   -------->
								</div>
					<!-------- wrap-table100  끝   -------->
							</div>
				<!-------- container-table100 끝	-------->
						</div>
			<!-------- limiter 끝-------->
					</div>
		<!--------questions_tab 끝-------->
				</div>
	<!--------  질문 게시판 영역 tab2 끝 -------->
	<script> 
	function QuestionDelete(boardno){
	this.boardno = boardno;
		alert("질문삭제 시작");
		var prodname = "${productvo.prodname }";
		var data = {
				"boardno" : boardno,
				"prodname" : prodname
					};
	$.ajax({
			url: "/newboot/boarddelete.mc",
			type : "post",
			data : data,
			succees : function(){
			},
			error : function(data){
					alert("fail");
			}
			});
			window.location.reload()
			};
	</script>
	<!-- 리뷰 게시판 영역 시작  -->
		<div id="tab3" class="tabcontent">
			<h3>Reviews</h3>
				<div id="reviews_tab">
					<div class="limiter">
						<div class="container-table100">
							<div class="wrap-table100">
							<!-- 리뷰게시판 기능 만들 영역  -->
								<div id="review_method" style='text-align: left;'>	
								<c:choose>
									<c:when test = "${loginid != null }">
								<button class="btn btn-success" onclick='ReviewInsert();'>리뷰 작성</button>													
									<div id = "review_insert"></div>
									<div id = "review_update"></div>		
								
									</c:when>
								
									<c:otherwise>
									<p> 로그인하시면 작성할 수 있습니다.</p>
									</c:otherwise>
								</c:choose>			
								</div>			
							<!-- 리뷰게시판 기능 만들 영역  -->
							<!-- REVIEW BOARD CRUD END-->
							<div class="table100 ver2 m-b-110">
								<div class="table100-head">
									<table>
										<thead>
										<tr class="row100 head">
											<th class="cell100 column1">내용</th>
											<th class="cell100 column2">작성자</th>
											<th class="cell100 column3">작성시간</th>
											<th class="cell100 column4">카테고리</th>
											<th class="cell100 column_star">평점</th>
											<th class="cell100 column5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<th>
										</tr>
										</thead>
									</table>
								</div>
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
									<c:forEach var="r" items="${boardvor }">
									<tr class="row100 body">
										<td class="cell100 column1">${r.bcontent }</td>
										<td class="cell100 column2">${r.userid }</td>
										<td class="cell100 column3">${r.bdate }</td>
										<td class="cell100 column4">리뷰${r.boardno }</td>
										<c:set var="idcheck" value="${loginid }"></c:set>
										<c:choose>
											<c:when test = "${r.userid == idcheck }">
											<th class="cell100 column_star">
											<script type="text/javascript">
												star = ${r.bstar}
											for (i = 0; i < star; i++)
												{
												document.write('<i class="fa fa-star"></i>')
												}
											for (j = 0; j < 5 - star; j++) {
												document.write('<i class="fa fa-star-o"></i>')
												}
											</script>
											</th>
											<td class="cell100 column5"><a href=# onclick = 'ReviewUpdate(${r.boardno },"${r.bcontent }");'>수정&#47;</a>
											<a href=# onclick = 'ReviewDelete(${r.boardno } );'>삭제</a></td>
											</c:when>
												<c:when test = "${idcheck == null }">
											<th class="cell100 column_star">
											<script type="text/javascript">
												star = ${r.bstar}
											for (i = 0; i < star; i++)
												{
												document.write('<i class="fa fa-star"></i>')
												}
											for (j = 0; j < 5 - star; j++) {
												document.write('<i class="fa fa-star-o"></i>')
												}
											</script>
											</th>
											<td class="cell100 column5">&nbsp;&nbsp;&nbsp;&nbsp;<a href=#></a>
											<a href=#>&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
											</c:when>
											<c:otherwise>
												<th class="cell100 column_star">
												<script type="text/javascript">
												star = ${r.bstar}
												for (i = 0; i < star; i++)
												{
													document.write('<i class="fa fa-star"></i>')
												}
												for (j = 0; j < 5 - star; j++)
												{
													document.write('<i class="fa fa-star-o"></i>')
												}
												</script>
												
												</th>
											<td class="cell100 column5">&nbsp;&nbsp;&nbsp;&nbsp;<a href=#></a>
											<a href=#>&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
											</c:otherwise>
										</c:choose>
									</tr>
									</c:forEach>
										</tbody>
										</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			<script> 
				// 리뷰 삭제 기능 시작// 
					function ReviewDelete(boardno){
						this.boardno = boardno;
						alert("리뷰삭제 시작");
						var prodname = "${productvo.prodname }";
						var data = {
							"boardno" : boardno,
							"prodname" : prodname
									};
							$.ajax({
								url: "/newboot/boarddelete.mc",
								type : "post",
								data : data,
								succees : function(){
									},
								error : function(data){
									alert("fail");
									}
								});
									window.location.reload()
								};
				//리뷰 삭제 기능 끝 //
				
				</script>
			<!-- 데이터 토글 기능 스크립트 시작-->
				<script>
				$(function() {$('ul.tab li').click(function() {
					var activeTab = $(this).attr('data-tab');
					$('ul.tab li').removeClass('current');
					$('.tabcontent').removeClass('current');
					$(this).addClass('current');
					$('#' + activeTab).addClass('current');
						})
					});
				</script>
			<!-- 데이터 토글 기능 스크립트 끝 -->


			</div>
		<!-- /product tab end -->
		</div>
	<!-- /row -->
	</div>
<!-- /container -->
	</div>
	</div>
	</div>
	<!-- /SECTION -->
	<!-- Section _ Related Products START  -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<div class="section-title text-center">
					<h3 class="title">Related Products</h3>
					</div>
				</div>
				<!-- Related product -->
				<div class="col-md-3 col-xs-6">
					<div class="product">
						<div class="product-img">
							<img src="view/img/2.jpg" alt="">
								<div class="product-label">
								<span class="sale">-30%</span>
								</div>
						</div>
						<div class="product-body">
						<p class="product-category">Category</p>
						<h3 class="product-name">
						<a href="#">product name goes here</a>
						</h3>
						<h4 class="product-price">$980.00
						<del class="product-old-price">$990.00</del>
						</h4>
						<div class="product-rating"></div>
						<div class="product-btns">
						<button class="add-to-wishlist">
						<i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span>
						</button>
						<button class="add-to-compare">
						<i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span>
						</button>
						<button class="quick-view">
						<i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
						</button>
						</div>
						</div>
						<div class="add-to-cart">
						<button class="add-to-cart-btn">
						<i class="fa fa-shopping-cart"></i> add to cart
						</button>
						</div>
					</div>
				</div>
				<!-- /product -->

				<!-- product -->
						<div class="col-md-3 col-xs-6">
							<div class="product">
								<div class="product-img">
									<img src="view/img/3.jpg" alt="">
									<div class="product-label">
										<span class="new">NEW</span>
									</div>
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
									<div class="product-rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i>
									</div>
									<div class="product-btns">
										<button class="add-to-wishlist">
											<i class="fa fa-heart-o"></i><span class="tooltipp">add
												to wishlist</span>
										</button>
										<button class="add-to-compare">
											<i class="fa fa-exchange"></i><span class="tooltipp">add
												to compare</span>
										</button>
										<button class="quick-view">
											<i class="fa fa-eye"></i><span class="tooltipp">quick
												view</span>
										</button>
									</div>
								</div>
								<div class="add-to-cart">
									<button class="add-to-cart-btn">
										<i class="fa fa-shopping-cart"></i> add to cart
									</button>
								</div>
							</div>
						</div>
						<!-- /product -->

						<div class="clearfix visible-sm visible-xs"></div>

						<!-- product -->
						<div class="col-md-3 col-xs-6">
							<div class="product">
								<div class="product-img">
									<img src="view/img/4.jpg" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
									<div class="product-rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o"></i>
									</div>
									<div class="product-btns">
										<button class="add-to-wishlist">
											<i class="fa fa-heart-o"></i><span class="tooltipp">add
												to wishlist</span>
										</button>
										<button class="add-to-compare">
											<i class="fa fa-exchange"></i><span class="tooltipp">add
												to compare</span>
										</button>
										<button class="quick-view">
											<i class="fa fa-eye"></i><span class="tooltipp">quick
												view</span>
										</button>
									</div>
								</div>
								<div class="add-to-cart">
									<button class="add-to-cart-btn">
										<i class="fa fa-shopping-cart"></i> add to cart
									</button>
								</div>
							</div>
						</div>
						<!-- /product -->

						<!-- product -->
						<div class="col-md-3 col-xs-6">
							<div class="product">
								<div class="product-img">
									<img src="view/img/5.jpg" alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
									<div class="product-rating"></div>
									<div class="product-btns">
										<button class="add-to-wishlist">
											<i class="fa fa-heart-o"></i><span class="tooltipp">add
												to wishlist</span>
										</button>
										<button class="add-to-compare">
											<i class="fa fa-exchange"></i><span class="tooltipp">add
												to compare</span>
										</button>
										<button class="quick-view">
											<i class="fa fa-eye"></i><span class="tooltipp">quick
												view</span>
										</button>
									</div>
								</div>
								<div class="add-to-cart">
									<button class="add-to-cart-btn">
										<i class="fa fa-shopping-cart"></i> add to cart
									</button>
								</div>
							</div>
						</div>
						<!-- /product -->

					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>

			<!-- Section _ Related Products END  -->


			<!-- jQuery Plugins -->
			<script src="js/bootstrap.min.js"></script>
</body>

</html>