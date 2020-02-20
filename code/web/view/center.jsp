<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- 필터에 관한 내용 -->
<script>
	/*
	
	String prodname;
	String brand;
	int price;
	String speccpu;
	String specram;
	String specstorage;
	String specsize;
	String specimg;
	int stock;
	 */
	function popularDisplay(data){
			var result='';
			$(data).each(function(idx,item){
				/*
				console.log(idx);
				str = '#spw'+(parseInt(idx)+1)
				console.log(str);
				$(str).attr("src", "img/laptop-img/"+item.specimage);
				console.log($(str).attr("src"));
				*/
				result += '<div class="single-product-wrapper">';
				result += '<div class="product-img">';
				result += '<img src=img/product-img/'+item.specimg + ' alt="">';
				result += '<img class="hover-img" src="img/product-img/ASUS1.jpg" alt="">'
				result += '<div class="product-favourite">';
				if("${loginid}"== ""){///로그인 안된 상태서 장바구니 누르면 로그인으로 이동 
					result += '<a href="http://localhost/newboot/login.mc" class="favme fa fa-heart"></a>';
				}else{
					result += '<a href="http://localhost/newboot/login.mc" class="favme fa fa-heart"></a>';
				}
				result += '</div>';
				result += '</div>';///productdetail.mc
				result += '<div class="product-description">';
				//result += '<span>Best</span> <a href="productdetail.mc?prodname='+item.prodname+'&specimg='+item.specimg+'&price='+item.price +'">';
				result += '<span>Best</span> <a href="productdetail.mc?prodname='+item.prodname+'">';
				result += '<h6>'+item.prodname+'</h6>';
				result += '</a>';
				result += '<p class="product-price">'+ item.price +'</p>';
				result += '<div class="hover-content">';
				result += '<div class="add-to-cart-btn">';
				
				if("${loginid}"== ""){///로그인 안된 상태서 장바구니 누르면 로그인으로 이동 
					result += '<a href="http://localhost/newboot/login.mc" class="btn essence-btn">Add to Cart</a>';
				}else{
					/////////////////여기서 cart를 추가했다. 
					console.log(item.specimg);
					result += '<a href="http://localhost/newboot/login.mc" class="favme fa fa-heart"></a>';
					result += '<button onclick="addCart(\''+ item.prodname +'\','+item.price +',\''+item.specimg  + '\')">Add to Cart</button>';
				}
				result += '</div>';
				result += '</div>';
				result += '</div>';
				result += '</div>';
				/*<div class="single-product-wrapper"> 
					<div class="product-img">
						<img src="img/laptop-img/11.jpg" alt=""><!-- 이거 변경  -->
						<img class="hover-img" src="img/laptop-img/11.jpg" alt=""> <!-- 이거 고정  -->
						<div class="product-favourite">
							<a href="#" class="favme fa fa-heart"></a><!-- url 변경 -->
						</div>
					</div>
					<div class="product-description">
						<span>Best</span> <a href="single-product-details.html">
							<h6>Knot Front Mini Dress</h6> <!-- 이거 변경   -->
						</a>
						<p class="product-price">$80.00</p> <!-- 이거 변경 -->
						<div class="hover-content">
							<div class="add-to-cart-btn">
								<a href="#" class="btn essence-btn">Add to Cart</a> <!-- 이거 변경 로그인 안 했을 때 불가하게 -->
							</div>
						</div>
					</div>
				</div>*/
			});
			//$('body > section > section:nth-child(3) > div:nth-child(2) > div > div > div').html(result);
	 		$('#yes').html(result);
	 };
	function display(data) {
		var results = '';
		var results2 = '';
		$(data).each(function(idx, item) {
							var result = '';
							console.log(item);
							///상품 페이지로 이동한다. 
							/*////예전 ui 기반 
							result += '<div class="col-lg-4 col-md-6 mb-4"><div class="card h-100">';
							result += '<a href="getProduct.mc?prodname='
									+ item.prodname +'&specimg=' +item.specimg +'&price=' +item.price
									+ '"><img class="card-img-top"';
							result += 'src ="img/product-img/';
							result += item.specimg +  '" alt = " "></a>'
									+ '<div class="card-body">';
							result += '<h4 class="card-title">';
							result += '<a href="getProduct.mc?prodname='
									+ item.prodname +'&specimg=' +item.specimg +'&price=' +item.price + '">' + item.prodname
									+ '</a>' + '</h4>' + '<h5>' + item.price
									+ '<h5>';
							result += '<p class="card-text">'+item.proddate +'</p></div><div class="card-footer">'
							result += '<small class="text-muted">&#9733;</small>';
							result += '</div></div></div>'
							results += result;
							*/
							var result2 = '';
							result2 +=  '<div class="col-12 col-sm-6 col-lg-4">';
							result2 +=  '<div class="single-product-wrapper">';
							result2 +=	'<div class="product-img">';
							result2 +=	'<img src="img/product-img/' + item.specimg + '" alt="">';
							result2 +=	'<img class="hover-img" src="img/product-img/ASUS1.jpg" alt="">';
							result2 +=	'<div class="product-badge offer-badge">';
							result2 +=	'<span>100%</span>'
							result2 +=	'</div>';
							result2 +=	'<div class="product-favourite">';
							if("${loginid}"== ""){///로그인 안된 상태서 장바구니 누르면 로그인으로 이동 
								result2 += '<a href="login.mc" class="favme fa fa-heart"></a>';
							}else{
								result2 += '<a href="#" class="favme fa fa-heart"></a>';
							}
								result2 += '</div>';
								result2 += '</div>';

								result2 += '<div class="product-description">';
								result2 += '<span>Best</span> <a href="productdetail.mc?prodname='+item.prodname+'">';
								result2 +=	'<h6>' + item.prodname + '</h6>';
								result2 +=	'</a>';
								result2 +=	'<p class="product-price">';
								result2 +=  '<span class="old-price">' + item.price + '</span>';
								result2 +=	'</p>';
								result2 +=	'<div class="hover-content">';
								result2 +=	'<div class="add-to-cart-btn">';
								
								if("${loginid}"== ""){///로그인 안된 상태서 장바구니 누르면 로그인으로 이동 
									result2 += '<a href="http://localhost/newboot/login.mc" class="btn essence-btn">Add to Cart</a>';
								}else{
									/////////////////여기서 cart를 추가했다. 
									console.log(item.specimg);
									result2 += '<a href="http://localhost/newboot/login.mc" class="favme fa fa-heart"></a>';
									result2 += '<button onclick="addCart(\''+ item.prodname +'\','+item.price +',\''+item.specimg  + '\')">Add to Cart</button>';
								}
								result2 +=  '</div>';
								result2 +=	'</div>';
								result2 +=  '</div>';
								result2 +=  '</div>';
								result2 +=  '</div>';
							
								results2 += result2;
							
						});
		$('.rows').append(results);
		$('.rows').append(results2);
	};
	function getData(value, sortBy) {
		var data = JSON.stringify(value);
		var sortBy = JSON.stringify(sortBy);
		console.log(sortBy);
		$.ajax({ 
			type : "post",
			dataType : 'JSON',
			data : {
				loadProds : 1,
				data1 : data,
				sortBy : sortBy
			},
			url : 'getFilter.mc',
			success : function(data) {
				display(data);
			},
			error : function(request, status, error) {
				alert("code = " + request.status + "\n message = "
						+ request.responseText + " error = " + error); // 실패 시 처리
			}
		});
	};
	function popularData(){
		$.ajax({
			url:'popular.mc',
			success:function(data){
				popularDisplay(data);
			}
		});
	}
	function clickButton(value) {
		getData(value);
	}
	$(document).ready(function() {		
		
		//popularData();//인기 데이터 5개
		
		$('#save_value3').click(function(){///// 조회된 것을 날짜 순으로 나타내기  
			var val = [];
			var myObject = {};
			/*여기다가 6개의 조건을 분기해서  javascript 객체 만든 후 json 데이터 만든다. */
	        $(':checkbox:checked').each(function(i){
	            val[i] = $(this).val();

	            myObject[i.toString()] = val[i];
	            console.log(myObject[i.toString()]);
	          });
			
			//console.log(myObject);
			getData(myObject, "date");
		});
		$('#save_value2').click(function(){///// 조회된 것을 가격순으로 나타내기  
			var val = [];
			var myObject = {};
			/*여기다가 6개의 조건을 분기해서  javascript 객체 만든 후 json 데이터 만든다. */
	        $(':checkbox:checked').each(function(i){
	            val[i] = $(this).val();
	            myObject[i.toString()] = val[i];
	            console.log(myObject[i.toString()]);
	          });
			getData(myObject, "price");
		});

		$('#save_value1').click(function(){///// 버튼 초기화 하기 
			$('input').removeAttr("checked");
		});
		$('#save_value').click(function(){///////////////필터 구현 
			var val = [];
			var myObject = {};
			/*여기다가 6개의 조건을 분기해서  javascript 객체 만든 후 json 데이터 만든다. */
	        $(':checkbox:checked').each(function(i){
	            val[i] = $(this).val();

				//console.log("val is " + val[i]);
	            myObject[i.toString()] = val[i];
	            //console.log(myObject[i.toString()]);
	          });
			
			//console.log(myObject);
			getData(myObject,'');
			//////클릭
			//////제품 상세로 넘어가자 
		});
		
	});
</script>

<!-- ##### New Arrivals Area Start ##### -->
<section class="new_arrivals_area section-padding-80 clearfix">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading text-center">
					<h2>Popular Products</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="container"  >
		<div class="row">
			<div class="col-12">
				<div id="yes" class="popular-products-slides owl-carousel">
				
				
				
				
				</div>
			</div>
		</div>
	</div>
</section>
<script>popularData();</script>
<!-- ##### 내가 추가 한 곳  ##### -->
<section class="new_arrivals_area section-padding-80 clearfix">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading text-center">
					<h2>필터 조건</h2>
				</div>
			</div>
		</div>
	</div>
	<table class="filter_table" border="1" border-collapse : collapse>
		<tr>
			<td class="table_first">제조사</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox1" name="selector[]"
						value="SAMSUNG"   /> 삼성</li>
					<li><input type="checkbox" id="ad_Checkbox1" name="selector[]"
						value="LG"   /> LG</li>
					<li><input type="checkbox" id="ad_Checkbox1" name="selector[]"
						value="HP"  /> HP</li>
					<li><input type="checkbox" id="ad_Checkbox1" name="selector[]"
						value="DELL" /> 델</li>
					<li><input type="checkbox" id="ad_Checkbox1" name="selector[]"
						value="ASUS"  /> ASUS</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td class="table_first">가격</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="500000"  /> 50이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="1000000"   /> 100이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="1500000"  /> 150이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="2000000"   /> 200이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="2500000"  /> 250 이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="3000000"  /> 300 이하</li>
					<li><input type="checkbox" id="ad_Checkbox2" name="selector[]"
						value="5000000"  /> 500 이하</li>

				</ul>
			</td>
		</tr>

		<tr>
			<td class="table_first">CPU</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox3" name="selector[]"
						value="I3"  /> I3</li>
					<li><input type="checkbox" id="ad_Checkbox3" name="selector[]"
						value="I5"   /> I5</li>
					<li><input type="checkbox" id="ad_Checkbox3" name="selector[]"
						value="RYZEN"   /> RYZEN</li>
					<li><input type="checkbox" id="ad_Checkbox3" name="selector[]"
						value="I7"   />I7</li>
					<li><input type="checkbox" id="ad_Checkbox3" name="selector[]"
						value="I9"  /> I9</li>
				</ul>
			</td>

		</tr>
		<tr>
			<td class="table_first">메모리</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox4" name="selector[]"
						value="4GB"  /> 4GB</li>
					<li><input type="checkbox" id="ad_Checkbox4" name="selector[]"
						value="8GB"  /> 8GB</li>
					<li><input type="checkbox" id="ad_Checkbox4" name="selector[]"
						value="16GB"  /> 16GB</li>
				</ul>
			</td>

		</tr>
		<tr>
			<td class="table_first">하드 디스크</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox5" name="selector[]"
						value="128GB"  />128GB</li>
					<li><input type="checkbox" id="ad_Checkbox5" name="selector[]"
						value="256GB"   /> 256GB</li>
					<li><input type="checkbox" id="ad_Checkbox5" name="selector[]"
						value="512GB"  /> 512GB</li>
					<li><input type="checkbox" id="ad_Checkbox5" name="selector[]"
						value="1TB"   /> 1TB</li>
				</ul>
			</td>

		</tr>
		<tr>
			<td class="table_first">모니터 크기</td>
			<td class="table_second">
				<ul>
					<li><input type="checkbox" id="ad_Checkbox6" name="selector[]"
						value="13.3" />13.3</li>
					<li><input type="checkbox" id="ad_Checkbox6" name="selector[]"
						value="14" /> 14</li>
					<li><input type="checkbox" id="ad_Checkbox6" name="selector[]"
						value="15.6"  /> 15.6</li>	
					<li><input type="checkbox" id="ad_Checkbox6" name="selector[]"
						value="17"  /> 17</li>
				</ul>
			</td>
		</tr>

	</table>
		<div style="text-align:center;"><!-- 버튼 구역 -->
			<br>
			<input type="button" id="save_value" name="save_value" value="제출"  class="btn btn-outline-primary btn-lg"/>
			<input type="button" id="save_value1" name="save_value" value="리셋"  class="btn btn-outline-primary btn-lg"/>
			<input type="button" id="save_value2" name="save_value" value="가격 순 "  class="btn btn-outline-primary btn-lg"/>
			<input type="button" id="save_value3" name="save_value" value="최신 순"  class="btn btn-outline-primary btn-lg"/>
		</div>
	<br> <br>
	
	<div class="rows"></div>
	
	<div class = "row"></div>