<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
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
<title>Essence - Fashion Ecommerce Template</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">

<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb_area bg-img"
		style="background-image: url(img/bg-img/breadcumb.jpg); top: 80px;">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="page-title text-center">
						<h2>Checkout</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- ##### Checkout Area Start ##### -->
	<div class="checkout_area section-padding-80" style="margin-top: 50px;">
		<div class="container">
			<div class="row">

				<div class="col-12 col-md-6">
					<div class="checkout_details_area mt-50 clearfix">

						<div class="cart-page-heading mb-30">
							<h5>Billing Address</h5>
						</div>

						<form action="#" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="first_name"> Name <span>*</span></label> <input
										type="text" class="form-control" id="first_name" value="${user.username }"
										required>
								</div>
								
								<div class="col-md-12 mb-3">
									<label for="phone_number"> Address <span>*</span></label> <input
										type="text" class="form-control" id="email" value="${user.useraddr }">
								</div>
								
								<div class="col-12 mb-3">
									<label for="phone_number">Phone No <span>*</span></label> <input
										type="text" class="form-control" id="phone_number" min="0"
										value="${user.userphone }">
								</div>
								
								<div class="col-12 mb-3">
									<label for="phone_number">Email Address <span>*</span></label>
									<input type="email" class="form-control" id="email_address"
										value="${user.email }">
								</div>
								
								<div class="col-12 mb-4">
									<label for="email_address">요청사항</label> <input type="email"
										class="form-control" id="email_address" value="">
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="col-12 col-md-6 col-lg-5 ml-lg-auto" style="top: 50px;">
					<div class="order-details-confirmation">

						<div class="cart-page-heading">
							<h5>Your Order</h5>
							<br>
						</div>

						<c:choose>

							<c:when test="${prodinfo != null }">

								<ul class="order-details-form mb-4">
									<li><span>Product</span> <span>${prodname }</span></li>
									<li><span>Subtotal</span> <span>${prodqnt }</span></li>
									<li><span>Subprice</span> <span>${prodinfo.price }</span></li>
									<li><span>Shipping</span> <span>Free</span></li>
									<li><span>Total</span> <span>${priceall }</span></li>
								</ul>

								<a
									href="saveorderinfo.mc?prodname=${prodinfo.prodname }&prodqnt=${prodqnt }&prodprice=${prodinfo.price }"
									class="btn essence-btn">Place Order</a>
							</c:when>

							<c:otherwise>
								<c:forEach var="u" items="${cart_info }">
									<ul class="order-details-form mb-4">
										<li><span>Product</span> <span>${u.prodname }</span></li>
										<li><span>Subtotal</span> <span>${u.quantity }</span></li>
										<li><span>Subprice</span> <span>${u.price }</span></li>
									</ul>
								</c:forEach>

								<ul class="order-details-form mb-4">
									<li><span>Shipping</span> <span>Free</span></li>
									<li><span>Total</span> <span>${priceall }</span></li>
								</ul>
								    <a href="savecartorder.mc" class="btn essence-btn">Place Order</a>	
							</c:otherwise>

						</c:choose>

						<script type="text/javascript">
							function popupOpen() {
								var popUrl = "view/paintjs/creditcard.html";
								var popOption = "width=370, height=360, left=800, top=300, resizable=no, scrollbars=no, status=no;";
								window.open(popUrl, "", popOption);
							}
						</script>
						<!--   <a href="javascript:popupOpen();" class="btn essence-btn">
							Place Order </a>-->

						<!-- <a href="saveorderinfo.mc?prodname=${prodinfo.prodname }&prodqnt=${prodqnt }&prodprice=${prodinfo.price }" class="btn essence-btn">Place Order</a>	 -->
						<!-- <a href="saveorderinfo.mc" class="btn essence-btn">Place Order</a>	-->

					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- ##### Checkout Area End ##### -->
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery.leanModal.min.js"></script>
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

</html>