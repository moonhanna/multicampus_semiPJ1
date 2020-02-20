<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Laptop Docter</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">

</head>
<script src="js/jquery/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

var cartAdded = 0;
var userTotalSum = 0;

if("${searched }" == "찾으시는 상품이 없습니다."){
	alert("찾으시는 상품이 없습니다. " + "${searched }");
}

/*
function checkDuplicateDataAdd(){
	$.ajax({
		url:'uu.mc',
		success:function(data){
			display(data);
		}
	});
};
*/

function showUserCartWriter(data){
		$(data).each(function(idx, item){/*
			item.quantity
			item.userid
			item.prodname
			item.cartno
			item.price*/
			var cartnum1 = '#' + item.prodname;
			var cartnum2 = '#' + item.prodname;

			var result = '';
			cartAdded++;
			result += '<div class="single-cart-item" id="cart'+ item.prodname +'">';
			//result += '<a href="getProduct.mc?prodname='+ item.prodname+ '&specimg='+item.specimg+'&price='+item.price +'" class = "product-image">';
			result += '<a href="productdetail.mc?prodname='+item.prodname+'"  class = "product-image">';
			result += '<img src="img/product-img/'+ item.specimg + '" class="cart-thumb" alt="">';
			result += '<div class="cart-item-desc">';
			result += '<h6 id = "iprodname' +item.prodname + '">' + item.prodname + '</h6>';
			result += '<h6 id = "iquantity' +item.prodname + '">' + item.quantity + '</h6>';
			result += '<p class="price">'+ item.price +'</p>';
			result += '</div>';
			result += '</a>';
			result += '<span class="product-remove"><i class="fa fa-close"';
			//https://stackoverflow.com/questions/17378199/uncaught-referenceerror-function-is-not-defined-with-onclick/17378538
			result += 'aria-hidden="true" id="'+ item.prodname +'" onclick=removeCart("'+item.prodname+ '",'+ item.cartAdded +','+ item.price+ ')></i></span>';
			$('.cart-list').prepend(result);
			
			$('#cartNum0').text(cartAdded);
			$('#cartNum1').text(cartAdded);
			userTotalSum += item.money;
			$('#cartTotal').text(userTotalSum);
		});
}

function showUserCart(){
		$.ajax({
			url:'showUserCart.mc',
			success:function(data){
				showUserCartWriter(data);
			}
		});
}

function removeCartData(prodname){
	userid = "${loginid }";
	$.ajax({
		type : "post",
		dataType : 'JSON', 
		data :{
			loadProds : 1, 
			userid : userid,
			prodname : prodname
		},
		url: 'removeCartData.mc',
		success : function(data) {
			console.log("data is " + data);
		},
		error : function(request, status, error) {
			alert("code = " + request.status + "\n message = "
					+ request.responseText + " error = " + error); // 실패 시 처리
		}
	}
	);
}

function addEvent(){
	
};


function checkDuplicateDataAdd(userid, prodname, count) {
	//count는 항상 1
	var userid = JSON.stringify(userid);
	var prodname = JSON.stringify(prodname);
	var count = 1;
	
	$.ajax({ 
		type : "post",
		dataType : 'JSON',
		data : {
			loadProds : 1,
			userid : userid,
			prodname : prodname
		},
		url : 'checkDuplicateDataAdd.mc',
		success : function(data) {
		},
		error : function(request, status, error) {
			alert("code = " + request.status + "\n message = "
					+ request.responseText + " error = " + error); // 실패 시 처리
		}
	});
};
function removeCart( prodname, cartAdded, price){///카트 초기화 하기  카트에서 x 버튼 눌
	var tagCart = "#cart"+prodname;
	var tempNum = Number($('#iquantity'+prodname).text())-1
	if(tempNum > 0){
		$('#iquantity'+prodname).text(tempNum);	
	}else{
		$(tagCart).remove();
		
		$('#cartNum0').text(Number($('#cartNum0').text())-1);
		$('#cartNum1').text(Number($('#cartNum1').text())-1);
	}
	cartTotal = Number($('#cartTotal').text())- price;
	$('#cartTotal').text(cartTotal);
	removeCartData(prodname);
}

$(document).ready(function() {
	
	///사용자의 db 정보 받아오기 --> 메인페이지 나올 때마다 
	if('${loginid}' != ''){
		showUserCart();
	}else{
		console.log("Not logged in");
	}
	
	
	
	///d
	
/*	
	cartAdded++;
	var result = '';
	result += '<div class="single-cart-item" id="">';
	result += '<a href="getProduct.mc?prodname='+ prodname+ '&specimg='+specimg+'&price='+price +'" class = "product-image"> <img ';
	result += 'src="img/product-img/'+ specimg + '" class="cart-thumb" alt="">';
	result += '<div class="cart-item-desc">';
	result += '<span class="badge">Laptop</span>';
	result += '<h6>' + prodname +'</h6>';
	result += '<p class="price">'+price+'</p>';
	result += '</div>';
	result += '</a>';
	result += '<span class="product-remove"><i class="fa fa-close" style = "width:15px; height: 15px; ';
	result += 'aria-hidden="true" onclick = ""></i></span>'; 
	result += '</div>';
	$('.cart-list').prepend(result);*/
});

</script>

<body>
	<!-- ##### Header Area Start ##### -->
	<header class="header_area">
		<div
			class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
			<!-- Classy Menu -->
			<nav class="classy-navbar" id="essenceNav">
				<!-- Logo -->
				<a class="nav-brand" href="index.html"><img
					src="img/core-img/laptopdoc.png" alt=""></a>
				<!-- Navbar Toggler -->
				<div class="classy-navbar-toggler">
					<span class="navbarToggler"><span></span><span></span><span></span></span>
				</div>
				<!-- Menu -->
				<div class="classy-menu">
					<!-- close btn -->
					<div class="classycloseIcon">
						<div class="cross-wrap">
							<span class="top"></span><span class="bottom"></span>
						</div>
					</div>
					<!-- Nav Start -->
					<div class="classynav">
						<ul>
							<li><a href="#">Shop</a>
								<div class="megamenu"><!--   <a href="udetail.mc?id=${loginid}"><   -->
									<ul class="single-mega cn-col-4">
										<li class="title">By Brand</li>
										<li><a href="shop.mc?brand=SAMSUNG&page=1&range=1">SAMSUNG</a></li>
										<li><a href="shop.mc?brand=HP&page=1&range=1">HP</a></li>
										<li><a href="shop.mc?brand=LG&page=1&range=1">LG</a></li>
										<li><a href="shop.mc?brand=DELL&page=1&range=1">DELL</a></li>
										<li><a href="shop.mc?brand=ASUS&page=1&range=1">ASUS</a></li>
									</ul>
									<ul class="single-mega cn-col-4">
										<li class="title">By CPU</li>
										<li><a href="shop.mc?speccpu=I9&page=1&range=1">I9</a></li>
										<li><a href="shop.mc?speccpu=I7&page=1&range=1">I7</a></li>
										<li><a href="shop.mc?speccpu=I5&page=1&range=1">I5</a></li>
										<li><a href="shop.mc?speccpu=I3&page=1&range=1">I3</a></li>
										<li><a href="shop.mc?speccpu=RYZEN&page=1&range=1">RYZEN</a></li>
									</ul>
									<div class="single-mega cn-col-4">
										<img src="img/core-img/laptopdoc.png" alt="">
									</div>
								</div></li>
                            <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="main.mc">Home</a></li>
										<li><a href="shop.mc?brand=SAMSUNG&page=1&range=1">Shop</a></li>
                                    <li><a href="productdetail.mc?prodname=ASUS85">Product Details</a></li>
                                    <li><a href="blog.mc">Blog</a></li>
                                    <li><a href="contact.mc">Contact</a></li>
                                </ul>
                            </li>
							<li><a href="blog.mc">Blog</a></li>
							<li><a href="contact.mc">Contact</a></li>
							<c:if test="${loginid=='admin'}">
                       			 <li><a href="goadmin.mc">adminpage</a></li>
                        	</c:if>
						</ul>
					</div>
					<!-- Nav End -->
				</div>
			</nav>

			<!-- Header Meta Data -->
			<div class="header-meta d-flex clearfix justify-content-end">
                <div class="search-area">
                    <form action="getSearch.mc" method="post">
                        <input type="search" name="search" id="headerSearch" placeholder="Laptop Name">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                    </div>
                    
				<c:choose>
				
					<c:when test="${loginid == null }">
						<div class="favourite-area">
							<a href="login.mc"><img src="img/core-img/login.svg" 
							alt="" style = "max-width: 40px !important"></a><!-- 내가 사이즈 40으로 줬다 -->
						</div>
					
					
					</c:when>
					<c:otherwise>
						<li style = "margin : auto 0;">${loginid }님</li>
						
						<div class="favourite-area"><!-- 로그아웃 -->
							<a href="logout.mc"><img src="img/core-img/logout.svg" 
							alt="" style = "max-width: 40px !important"></a><!-- 내가 사이즈 40으로 줬다 -->
						</div>
						<!-- User Login Info -->
						<!--<h1>User List Page</h1><c:forEach var="u" items="${ulist }"><h3><a href="udetail.mc?id=${u.id }">${u.id }  ${u.name }</a></h3></c:forEach>-->
						<div class="user-login-info">
							<a href="udetail.mc?id=${loginid}"><img src="img/core-img/user.svg" alt="" style = "max-width: 40px !important"></a>
						</div>
						<!-- Cart Area -->
						<div class="cart-area">
							<a href="#" id="essenceCartBtn"><img
								src="img/core-img/bag.svg" alt="" style = "max-width: 40px !important"> <span id = "cartNum0">0</span></a>
						</div>

					</c:otherwise>
				</c:choose>

				<!-- Search Area -->
				<!-- Favourite Area -->
			</div>

		</div>
	</header>
	<!-- ##### Header Area End ##### -->

	<!-- ##### Right Side Cart Area ##### -->
	<div class="cart-bg-overlay"></div>

	<div class="right-side-cart-area">

		<!-- Cart Button -->
		<div class="cart-button"><!-- $('.cart-button span'). -->
			<a href="#" id="rightSideCart"><img src="img/core-img/bag.svg"
				alt=""> <span id = "cartNum1">0 </span></a> <!-- 디비에서 사용자의 카트 개수를 가져온다.  -->
		</div>

		<div class="cart-content d-flex">

			<!-- Cart List Area -->
			<div class="cart-list">
			


			
			</div>

			<!-- Cart Summary -->
			<div class="cart-amount-summary">

				<h2>Summary</h2>
				<ul class="summary-table">
					<li><span>delivery:</span> <span>Free</span></li>
					<li><span>total:</span> <span id = "cartTotal">$232.00</span></li>
				</ul>
				<div class="checkout-btn mt-100">
					<a href="cartorder.mc" class="btn essence-btn">check out</a>
					<a href="cartdetail.mc" class="btn essence-btn">전체cart보기</a>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Right Side Cart End ##### -->


	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!여기서 부터 센터 시작  -->



<!--  

-->


	<section>	
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="center.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp" />
			</c:otherwise>
		</c:choose>
	</section>

	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!센터 끝  -->
	<!-- ##### Footer Area Start ##### -->
	<footer class="footer_area clearfix">
		<div class="container">
			<div class="row">
				<!-- Single Widget Area -->
				<div class="col-12 col-md-6">
					<div class="single_widget_area d-flex mb-30">
						<!-- Logo -->
						<div class="footer-logo mr-50">
							<a href="#"><img src="img/core-img/laptopdoc.png" alt=""></a>
						</div>
						<!-- Footer Menu -->
						<div class="footer_menu">
							<ul>
								<li><a href="shop.mc">Shop</a></li>
								<li><a href="blog.mc">Blog</a></li>
								<li><a href="contact.mc">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- Single Widget Area -->
				<div class="col-12 col-md-6">
					<div class="single_widget_area mb-30">
						<ul class="footer_widget_menu">
							<li><a href="#">Order Status</a></li>
							<li><a href="#">Payment Options</a></li>
							<li><a href="#">Shipping and Delivery</a></li>
							<li><a href="#">Guides</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Terms of Use</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="row align-items-end">
				<!-- Single Widget Area -->
				<div class="col-12 col-md-6">
					<div class="single_widget_area">
						<div class="footer_heading mb-30">
							<h6>Subscribe</h6>
						</div>
						<div class="subscribtion_form">
							<form action="#" method="post">
								<input type="email" name="mail" class="mail"
									placeholder="Your email here">
								<button type="submit" class="submit">
									<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
				<!-- Single Widget Area -->
				<div class="col-12 col-md-6">
					<div class="single_widget_area">
						<div class="footer_social_area">
							<a href="#" data-toggle="tooltip" data-placement="top"
								title="Facebook"><i class="fa fa-facebook"
								aria-hidden="true"></i></a> <a href="#" data-toggle="tooltip"
								data-placement="top" title="Instagram"><i
								class="fa fa-instagram" aria-hidden="true"></i></a> <a href="#"
								data-toggle="tooltip" data-placement="top" title="Twitter"><i
								class="fa fa-twitter" aria-hidden="true"></i></a> <a href="#"
								data-toggle="tooltip" data-placement="top" title="Pinterest"><i
								class="fa fa-pinterest" aria-hidden="true"></i></a> <a href="#"
								data-toggle="tooltip" data-placement="top" title="Youtube"><i
								class="fa fa-youtube-play" aria-hidden="true"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col-md-12 text-center">
					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart-o" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
				</div>
			</div>

		</div>
	</footer>
	<!-- ##### Footer Area End ##### -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script src="js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="js/plugins.js"></script>
	<!-- Classy Nav js -->
	<script src="js/classy-nav.min.js"></script>
	<!-- Active js -->
	<script src="js/active.js"></script>
	
</body>
<script>
function addCart(prodname, price, specimg){ ////카트에 상품 담기  ajax
	
	var val = [];
	var myObject = {};
	/*여기다가 6개의 조건을 분기해서  javascript 객체 만든 후 json 데이터 만든다. */
   /*
	$(':checkbox:checked').each(function(i){
        val[i] = $(this).val();

        myObject[i.toString()] = val[i];
        console.log(myObject[i.toString()]);
      });
	
	console.log(myObject);
	getData(myObject, "date");
	*/
	myObject = {};
	var userid = "${loginid }";
	var prodname = prodname;

	///동일 카트인지 중복 체크 
	checkDuplicateDataAdd(userid, prodname, 1);//cartno return 해야 
	
	cartAdded++;////////////카트 더해진 숫자 
	var result = '';
	var iprodname = '#iprodname'+ prodname;
	var results = $(iprodname).text();
	if($(iprodname).text() == prodname){

		var tempNum = Number($('#iquantity'+prodname).text())+1
		$('#iquantity'+prodname).text(tempNum);
	}else{
		result += '<div class="single-cart-item" id="cart'+ prodname +'">';
		result += '<a href="getProduct.mc?prodname='+ prodname+ '&specimg='+specimg+'&price='+price +'" class = "product-image"> <img ';
		result += 'src="img/product-img/'+ specimg + '" class="cart-thumb" alt="">';
		result += '<div class="cart-item-desc">';
		result += '<h6 id = "iprodname' +prodname + '">' + prodname + '</h6>';
		result += '<h6 id = "iquantity' +prodname + '">' + 1 + '</h6>';
		result += '<p class="price">'+price+'</p>';
		result += '</div>';
		result += '</a>';
		result += '<span class="product-remove"><i class="fa fa-close"';
		result += 'aria-hidden="true" id="'+ prodname +'" onclick=removeCart("'+prodname+ '",'+ cartAdded +','+ price + ')></i></span>';
		result += '</div>';
		//document.getElementById(cartAdded).addEventListener ("click", removeCart(prodname, cartAdded), false);	

		$('.cart-list').prepend(result);
		$('#cartNum0').text(Number($('#cartNum0').text())+1);
		$('#cartNum1').text(Number($('#cartNum1').text())+1);
	}
	userTotalSum += price;
	$('#cartTotal').text(userTotalSum);
}
</script>

</html>