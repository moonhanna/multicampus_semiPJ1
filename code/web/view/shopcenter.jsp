<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${loginid == null }">
		<c:forEach var="p" items="${plist }">
			<div class="col-12 col-sm-6 col-lg-4">
				<div class="single-product-wrapper">
					<!-- Product Image -->
					<div class="product-img">
						<img src="img/product-img/${p.specimg }" alt="">
						<!-- Hover Thumb -->
						<img class="hover-img" src="img/product-img/ASUS1.jpg" alt="">

						<!-- Product Badge -->
						<!-- Favourite -->
						<div class="product-favourite">
							<a href="login.mc" class="favme fa fa-heart"></a>
						</div>
					</div>

					<!-- Product Description -->
					<div class="product-description">
						<span>BEST</span> <!--<a href="productdetail.mc?prodname='+item.prodname+'">';  -->
						<a href="productdetail.mc?prodname=${p.prodname }">
							<h6>${p.prodname }</h6>
						</a>
						<p class="product-price">
							<span class="old-price">${p.price } </span> ${p.price }
						</p>

						<!-- Hover Content -->
						<div class="hover-content">
							<!-- Add to Cart -->
							<div class="add-to-cart-btn">
								<a href="login.mc" class="btn essence-btn">Add to Cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</c:forEach>

	</c:when>
	<c:otherwise>
		<c:forEach var="p" items="${plist }">
			<div class="col-12 col-sm-6 col-lg-4">
				<div class="single-product-wrapper">
					<!-- Product Image -->
					<div class="product-img">
						<img src="img/product-img/${p.specimg }" alt="">
						<!-- Hover Thumb -->
						<img class="hover-img" src="img/product-img/ASUS1.jpg" alt="">

						<!-- Product Badge -->
						<!-- Favourite -->
						<div class="product-favourite">
							<a href="#" class="favme fa fa-heart"></a>
						</div>
					</div>
					<div class="product-description">
						<span>BEST</span>						
						<a href="productdetail.mc?prodname=${p.prodname }">
						<!-- <a href="getProduct.mc?prodname=${p.prodname }&specimg=${p.specimg }&${p.price }"> --> 
							<h6>${p.prodname }</h6>
						</a>
						<p class="product-price">
							<span class="old-price">${p.price } </span> ${p.price }
						</p>
						<div class="hover-content">
							<!-- Add to Cart -->
							<div class="add-to-cart-btn">
								<button onclick="addCart('${p.prodname }',${p.price },'${p.specimg }')">Add to Cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
