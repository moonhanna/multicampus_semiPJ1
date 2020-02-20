<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->


<title>Cart</title>

<!--===============================================================================================-->
<link rel="icon" type="image/png" href="view/fashe/images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/fonts/themify/themify-icons.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="view/fashe/vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="view/fashe/css/util.css">
<link rel="stylesheet" type="text/css" href="view/fashe/css/main.css">
<!--===============================================================================================-->
</head>

<!-- Title Page -->
	<!--  <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
		style="background-image: url(view/fashe/images/icons/mountain.jpg);">
		<h2 class="l-text2 t-center">Check your Cart!</h2>
	</section> -->
	
	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb_area bg-img"
		style="background-image: url(img/bg-img/breadcumb.jpg); top: 80px;">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="page-title text-center">
						<h2>Check Your Cart!!</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->


<section class="cart bgwhite p-t-70 p-b-100">
		<div class="container">


		<c:forEach var="u" items="${clist }">
			<!-- <ul class="order-details-form mb-4">
				<li><span>Product</span> <span>${u.prodname }  ${u.quantity }</span></li>
			</ul>  -->
		

<!-- Cart item -->
			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
				
					<table class="table-shopping-cart">
						<tr class="table-head">
							<th class="column-1"></th>
							<th class="column-2">Product</th>
							<th class="column-3">Price</th>
							<th class="column-4 p-l-70">Quantity</th>
							<th class="column-5">Total</th>
						</tr>


						<!-- 카트리스트 상세 -->
					

							<tr class="table-row">
								<td class="column-1">
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="img/product-img/${u.specimg }" alt="">
									</div>
								</td>
								<td class="column-2">${u.prodname }</td>
								<td class="column-3">${u.price}원</td>
								<!-- 수량(Quantity) -->
								<td class="column-4 p-l-70">
									<div class="flex-w bo5 of-hidden w-size15">
										<!-- 수량 증가 감소 반영 -->
										<!--   <button
											class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
										</button> -->

										
										<input class="size8 m-text18 t-center num-product"
											type="number" name="num-product1" value="${u.quantity }">

										<!-- <button
											class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
										</button> -->
									</div>
								</td>
								<td class="column-5">${u.money }원</td>
							</tr>
					</table>
				</div>
			
			</div>
			</c:forEach>
			<!-- cart테이블 부분 끝 -->
			
			
				<!-- Total -->
			<div
				class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">Cart Totals</h5>

				<!-- subtotal  -->
				 <div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm"> 총 수량: </span> <span
						class="m-text21 w-size20 w-full-sm"> ${cartquantity } </span>
				</div>  
				 <div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm"> 총 장바구니금액: </span> <span
						class="m-text21 w-size20 w-full-sm"> ${cartprice } </span>
				</div>   

				<!--  -->
				<div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm"> Shipping: </span>

					<div class="w-size20 w-full-sm">
						<p class="s-text8 p-b-23">배송비 전액 무료 이벤트!</p>

					
					</div>
				</div>


				
				<div class="size15 trans-0-4">
					<!-- Button -->
					<a href="cartorder.mc" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"> 
					Proceed to Checkout</a>
					
				</div>
			</div>
	
			
			
			
			
	</div>
	</section>