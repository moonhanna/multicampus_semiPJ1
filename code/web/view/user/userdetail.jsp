<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>User Detail Page</h1>


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
											<legend class="">User Detail Page</legend>
										</div>
										<div class="control-group">
											ID: ${duser.userid } <br> PWD: ${duser.userpwd } <br>
											NAME: ${duser.username } <br> ADDR: ${duser.useraddr }<br>
											PHON: ${duser.userphone }<br> RANKS: ${duser.ranks }<br>
											BIRTH: ${duser.birth } <br> GENDER: ${duser.gender } <br>
											EMAIL: ${duser.email } <br>
											<div class="controls">
												<a href="uupdate.mc?id=${duser.userid }">
													<button class="btn btn-success">update</button>
												</a> <a href="udel.mc?id=${duser.userid }">
													<button class="btn btn-primary">delete</button>
												</a>
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>