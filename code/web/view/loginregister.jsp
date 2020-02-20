<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
<!--로그인과 회원가입을 담당하는 jsp 페이지 입니다.   -->
<script>

$(document).ready(function() {
	  $("#password2").keyup(validate);
	});


	function validate() {
	  var password1 = $("#password1").val();
	  var password2 = $("#password2").val();

	    
	 
	    if(password1 == password2) {
	       $("#validate-status").text("valid");        
	    }
	    else {
	        $("#validate-status").text("invalid");  
	    }
	}


$(function () {
    $("#user_id").blur(function () {
        // id = "id_reg" / name = "userId"
        var user_id = $('#user_id').val();
        var Myobject = { "user_id": user_id }
        $.ajax({
            url: 'idcheck.mc',
            type: 'post',
            data : Myobject,
            success: function (data) {
                console.log("1이 중복 ");
                if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    console.log("hahahah")
                    $("#id_check").text("사용중인 아이디입니다");
               	    $("#id_check").css("color", "red");
               		$("#reg_submit").attr("disabled", true);
                    console.log("중복된 데이터 ");
	            }else{
                    $("#id_check").text("사용가능한 아이디입니다");
               	    $("#id_check").css("color", "green");
               		$("#reg_submit").attr("disabled", true);
                }
                
                console.log("dddd")
            }, error: function () {
                console.log("실패");
            }
        });
    });
    
    $("#p2").keyup(validate);
    
    function validate(){
    	var p1 = $('#p1').val();
    	var p2 = $('#p2').val();
    	console.log(p1 + p2);
    	if(p1 == p2){
    		console.log("same pwd");
    		document.getElementById('validate-status').style.color = "black";
    		document.getElementById('validate-status').innerHTML = 'same';


    		$("#validate-status").text = "Different"
    	}else{
    		console.log("different pwd");
    		document.getElementById('validate-status').style.color = "red";	
        	document.getElementById('validate-status').innerHTML = 'different';

    	}
    }

})





</script>
<br>
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
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3>Have an Account?</h3>
					</div>
					<div class="modal-body">
						<div class="well">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
								<li><a href="#create" data-toggle="tab">Create Account</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane active in" id="login">


									<!-- <form action="loginimpl.mc" method="post">ID<input type="text" name="id"><br> PWD<input type="text"name="pwd"><br> <input type="submit" value="LOGIN"><br></form> -->



									<form class="form-horizontal" action="loginimpl.mc"
										method="POST">
										<fieldset>
											<div id="legend">
												<legend class="">Login</legend>
											</div>
											<div class="control-group">
												<!-- Username -->
												<label class="control-label" for="username">ID</label>

												<div class="controls">
													<input type="text" id="username" name="id" placeholder=""
														class="input-xlarge">
												</div>

											</div>

											<div class="control-group">
												<!-- Password-->
												<label class="control-label" for="password">Password</label>
												<div class="controls">
													<input type="password" id="password" name="pwd"
														placeholder="" class="input-xlarge">
												</div>
											</div>


											<div class="control-group">
												<!-- Button -->
												<div class="controls">
													<input type="submit" value="Login" class="btn btn-success">
													<!--  <button class="btn btn-success">Login</button>   -->
												</div>
											</div>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane fade" id="create">
									<form id="tab" action="uaddimpl.mc" method="post">
										(*)표시는 필수 입력 (나중에 구현), 정규식, 오라클 birth 는 년도 
										<label>Id(*)</label> <input type="text" id="user_id" name="userid" value="" placeholder="ID는 영어와 숫자만 가능, 20자리 미만 " class="input-xlarge" required="required" >
										<div class="check_font" id="id_check"></div>
										<label>Password(*)</label> <input type="text" required="required" name="userpwd" value="" class="input-xlarge" id = "p1">
										<label>Password Check(*)</label> <input type="text" required="required" name="userpwd_check" value="" class="input-xlarge" id = "p2">
										<div id = "validate-status"></div>
										<label>Name(*)</label> <input type="text" name="username" required="required" value="" class="input-xlarge"> 
										<label>Address</label> <input type="text" name="useraddr" value="" class="input-xlarge"> 
										<label>Phone</label> <input type="text" name="userphone" value="" class="input-xlarge" > 
										<!--  <label>Rank</label> <input type="text" name="ranks" value="" class="input-xlarge"> --> <!-- 랭크는 기본으로 customer -->
										<label>Birth : 6자리 작성해주세요(예 : 950804)</label>
										<input type="text" name="birth" maxlength="6" placeholder="ex)950804" size="6" >
										<label>Gender</label> 
										<input type="radio" id="gender"name="gender" value="남" checked class="input-xlarge">남
										<input type="radio" id="gender"name="gender" value="여" checked class="input-xlarge">여
										
										<label>Email : red means wrong REGEX</label> <input type="text" name="email" value="" class="input-xlarge"  pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="Invalid email address"> 
										

										<div>
											<button class="btn btn-primary">Create Account</button>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
