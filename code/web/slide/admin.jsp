<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>


<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="slide/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="slide/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="slide/css/owl.carousel.css">
<link rel="stylesheet" href="slide/style.css">
<link rel="stylesheet" href="slide/css/responsive.css">

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


<style>
#container {
	margin: 0 auto;
	width: 80%;
	height: 600px;
	border: 2px solid black;
}
</style>

<script>
	var acontent = new Array();
	var boardno = new Array();

	function Answer(boardno) {

		var result = '';

		result += "<div class=form-group>"
		result += '<form action="banswerimpl.mc" method="post">'
		result += "<input type='text' name= 'bcontent' placeholder= '내용을입력해주세요' style ='width:100%; height:50px; font-size:17px; outline-style:solid;'>"
		result += "<input type='hidden' name='boardno' value='"+boardno+"'>"
		result += '<input type="submit" value="등록하기" style="font-size:17px;">'
		result += '</form></div>'

		//$('#question_insert').append(result);
		document.getElementById("question_insert").innerHTML = result;
		//document.getElementById("testttttt").innerHTML = result;

	};

	function viewAnswer(boardnoo) {
		var num = 0;
		var result = '';

		for (var i = 0; i < boardno.length; i++) {
			if (boardno[i] == boardnoo) {
				num = i;
			}
		}

		result += "<div class=form-group>"
		result += "<input type='text' name= 'bcontent' placeholder= '"
				+ acontent[num]
				+ "' style ='width:100%; height:50px; font-size:17px; outline-style:solid;'>"
		result += '</div>'

		//??어디에..
		//$('#question_insert').append(result);
		document.getElementById("question_insert").innerHTML = result;

	};

	function display(data) {

		var Month_Data_List = new Array();
		var Price_Data_List = new Array();
		var price = Array.apply(null, new Array(12)).map(
				Number.prototype.valueOf, 0);

		$(data).each(function(idx, item) {

			switch (item.Month) {
			case 1:
				price[0] += item.price;
				break;
			case 2:
				price[1] += item.price;
				break;
			case 3:
				price[2] += item.price;
				break;
			case 4:
				price[3] += item.price;
				break;
			case 5:
				price[4] += item.price;
				break;
			case 6:
				price[5] += item.price;
				break;
			case 7:
				price[6] += item.price;
				break;
			case 8:
				price[7] += item.price;
				break;
			case 9:
				price[8] += item.price;
				break;
			case 10:
				price[9] += item.price;
				break;
			case 11:
				price[10] += item.price;
				break;
			case 12:
				price[11] += item.price;
				break;
			default:
			}

		});

		var data = [ {
			name : 'SDR LAPTOPDOC',
			data : [ price[0], price[1], price[2], price[3], price[4],
					price[5], price[6], price[7], price[8], price[9],
					price[10], price[11] ]
		} ];

		Highcharts.chart('container', {
			chart : {
				type : 'line'
			},

			title : {
				text : 'LAPTOPDOC'
			},

			subtitle : {
				text : '총 판매량'
			},

			xAxis : {
				categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
						'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ]
			},

			yAxis : {
				min : 0,
				title : {
					text : '판매액'
				}
			},

			plotOptions : {
				line : {
					dataLabels : {
						enabled : true
					},
					enableMouseTracking : false
				}
			},
			series : data
		});
	};

	function getData() {
		$.ajax({
			url : 'getdata.mc',
			success : function(data) {
				console.log(data);
				display(data);
			},
			error : function() {
				alert("fail");
			}
		})
	};

	function board(data) {

		console.log(boardno);

		var result = '';
		$(data)
				.each(
						function(idx, item) {

							result += '<tr class="row100 body">'
							result += '<td class="cell100 column1">';
							result += item.bcontent;
							result += '</td>';
							result += '<td class="cell100 column1">';
							result += item.userid;
							result += '</td>';
							result += '<td class="cell100 column1">';
							result += item.bdate;
							result += '</td>';
							result += '<td class="cell100 column1">';
							result += item.btype;
							result += '</td>';
							result += '<td class="cell100 column1">';
							result += item.bstar;
							result += '</td>';
							result += '<td class="cell100 column1">';
							result += '<button class="btn btn-success" onclick="Answer('
									+ item.boardno + ');">답변하기</button>';

							for (var i = 0; i < boardno.length; i++) {
								if (boardno[i] == item.boardno) {

									result += '<button class="btn btn-success" onclick="viewAnswer('
											+ item.boardno
											+ ');">답변보기</button>';

								}
							}

							result += '</td>';
							result += '</tr>';

						});

		$('.table100-body.js-pscroll>table>tbody').html(result);

	};

	function savelist(data) {
		$(data).each(function(idx, item) {

			acontent[idx] = item.acontent;
			boardno[idx] = item.boardno;
		});
	};

	function getAnswer() {
		$.ajax({
			url : 'getanswer.mc',
			success : function(data) {
				savelist(data);
			},
			error : function() {
				alert("fail");
			}
		})
	};

	function BoardData() {
		$.ajax({
			url : 'boarddata.mc',
			success : function(data) {
				board(data);
			},
			error : function() {
				alert("fail");
			}
		})
	};

	$(document).ready(function() {
		getAnswer();
		getData();
		BoardData();
	});
</script>


</head>

<script type="text/javascript"></script>


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

					<!-- Nav End -->
				</div>
			</nav>

			<!-- Header Meta Data -->
			<div class="header-meta d-flex clearfix justify-content-end">
				<div class="search-area">
					<form action="getSearch.mc" method="post">
						<input type="search" name="search" id="headerSearch"
							placeholder="Laptop Name">
						<button type="submit">
							<i class="fa fa-search" aria-hidden="true"></i>
						</button>
					</form>
				</div>

				<div class="user-login-info">
					<a href="#">관리자<img src="img/core-img/user.svg" alt=""
						style="max-width: 40px !important"></a>
				</div>


				<!-- Search Area -->
				<!-- Favourite Area -->
			</div>

		</div>
	</header>
	<!-- ##### Header Area End ##### -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<div class="slider-area">
		<!-- Slider -->
		<div class="block-slider block-slider4">
			<ul class="" id="bxslider-home4">

				<li>
					<div class="container h-100">
						<div class="row h-100 align-items-center">
							<div class="col-12">
								<div class="page-title text-center">
									<h2>Monthly Sales Volume</h2>
								</div>
							</div>
						</div>
					</div> <br>
					<div id="container"></div>
				</li>

				<li>
					<div class="container h-100">
						<div class="row h-100 align-items-center">
							<div class="col-12">
								<div class="page-title text-center">
									<h2>리뷰 관리</h2>
								</div>
							</div>
						</div>
					</div> <br>



					<div class="container-table100">
						<div class="wrap-table100">
							<!-- 리뷰게시판 기능 만들 영역  -->
							<div id="review_method" style='text-align: left;'></div>
							<!-- 리뷰게시판 기능 만들 영역  -->
							<!-- REVIEW BOARD CRUD END-->
							<div class="table100 ver2 m-b-110">
								<div class="table100-head">
									<table>
										<thead>
											<tr class="row100 head">
												
												<th class="cell100 column5">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 내용</th>
												<th class="cell100 column5">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; 작성자  </th>
												<th class="cell100 column5">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp; 작성시간</th>
												<th class="cell100 column5">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; 카테고리 </th>
												<th class="cell100 column5">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; 평점</th>
											</tr>
										</thead>
									</table>
								</div>

								<div class="table100-body js-pscroll">
									<table>
										<tbody>
											<!-- 디비 내용 -->

										</tbody>

									</table>
									<div id="question_insert"></div>
								</div>
								
							</div>
						</div>
					</div>
				</li>
				
				<li><div class="container h-100">
						<div class="row h-100 align-items-center">
							<div class="col-12">
								<div class="page-title text-center">
									<h2>회원 정보</h2>
								</div>
							</div>
						</div>
					</div>
					
					</li>
			</ul>
		</div>
		<!-- ./Slider -->
	</div>
	<!-- End slider area -->



	<!-- ##### Footer Area End ##### -->

	<!-- jQuery (Necessary for All JavaScript Plugins)  -->
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

	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	<script src="slide/js/owl.carousel.min.js"></script>
	<script src="slide/js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="slide/js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="slide/js/main.js"></script>

	<!-- Slider -->
	<script type="text/javascript" src="slide/js/bxslider.min.js"></script>
	<script type="text/javascript" src="slide/js/script.slider.js"></script>


</body>

</html>