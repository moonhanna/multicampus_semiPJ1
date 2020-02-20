<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<a href="main.mc"><span>처음 화면으로 ~~</span></a>
<h1>bye bye Page</h1>
<body>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" href="css/boot-login.css" id="bootstrap-css">
	<!-- 내가 css 추가 해서 modal-body 사이즈 키웠다.  -->
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="" id="loginModal">
					<div class="modal-header"></div>
					<div class="modal-body">
						<div class="well">
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane active in" id="login">
									<!-- <form action="loginimpl.mc" method="post">ID<input type="text" name="id"><br> PWD<input type="text"name="pwd"><br> <input type="submit" value="LOGIN"><br></form> -->
									<fieldset>
										<div id="legend">
											<legend class="">hellow</legend>
										</div>
										<div class="control-group">
											<body>
												<h1>${loginid }님환영합니다.<br><a href="main.mc"><span>쇼핑하러가자~~!! </a> </h1>
											</body>
											

										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>