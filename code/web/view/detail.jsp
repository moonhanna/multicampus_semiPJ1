<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script> 



</script>
<!-- 필터에 관한 내용 -->



<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${prodname} ${specimg} ${price}</h1>
	
	<section class="single_product_details_area d-flex align-items-center">

		<!-- Single Product Thumb -->
		<div class="single_product_thumb clearfix">
			<div class="product_thumbnail_slides owl-carousel">
				<img src="img/product-img/product-big-1.jpg" alt=""> <img
					src="img/product-img/product-big-2.jpg" alt=""> <img
					src="img/product-img/product-big-3.jpg" alt="">
			</div>
		</div>

		<!-- Single Product Description -->
		<div class="single_product_desc clearfix">
			<span>Laptop</span> <a href="cart.html">
				<h2>${prodname} </h2>
			</a>
			<p class="product-price">
				<span class="old-price">${price}</span> ${price}
			</p>
			<p class="product-desc"> 최신 하드웨어 , 최신 소프트웨어 </p>

			<!-- Form -->
			<form class="cart-form clearfix" method="post">
				<!-- Select Box -->
				<div class="select-box d-flex mt-50 mb-30">
					<select name="select" id="productSize" class="mr-5">
						<option value="value">Size: XL</option>
						<option value="value">Size: X</option>
						<option value="value">Size: M</option>
						<option value="value">Size: S</option>
					</select> <select name="select" id="productColor">
						<option value="value">Color: Black</option>
						<option value="value">Color: White</option>
						<option value="value">Color: Red</option>
						<option value="value">Color: Purple</option>
					</select>
				</div>
				<!-- Cart & Favourite Box -->
				<div class="cart-fav-box d-flex align-items-center">
					<!-- Cart -->
					<button type="submit" name="addtocart" value="5"
						class="btn essence-btn">Add to cart</button>
					<!-- Favourite -->
					<div class="product-favourite ml-4">
						<a href="#" class="favme fa fa-heart"></a>
					</div>
				</div>
			</form>
		</div>
	</section>

</body>
</html>