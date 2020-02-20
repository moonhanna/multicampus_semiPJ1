<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>User Detail Page</h1>
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
                    console.log("중복된 데이터 ")
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

});





</script>

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
										<form action="uupdateimpl.mc" method="post">
											<div class="control-group">
													<!--  ID 인풋 -->
													ID<br>
													<input type="text" name="userid" value="${uuser.userid }"
													readonly="readonly"><br>
													
													PWD <br>
													<input type="text" name="userpwd" value="${uuser.userpwd }"
													class="input-xlarge" id="p1"> <br>
													
													NAME<br> <input
													type="text" name="username" value="${uuser.username }"
													class="input-xlarge"> <br>
													Address<br> <input type="text"
													name="useraddr" value="${uuser.useraddr }"
													class="input-xlarge"> <br>
													Phone<br> <input type="text"
													name="userphone" value="${uuser.userphone }"
													class="input-xlarge"> <br>
													<input type="hidden" name="ranks" value="${uuser.ranks }">
													Birth :<br>(ex:1991/08/17,91/08/17) <br>
													<input type="text" name="birth" maxlength="" placeholder="ex)950804" size="" value="${uuser.birth }" ><br>
													
													Gender<br> 
													<input type="radio" id="gender"name="gender" value="${uuser.gender}" checked class="input-xlarge">남
													<input type="radio" id="gender"name="gender" value="${uuser.gender}" checked class="input-xlarge">여
												    <br>
													Email:<br> red means wrong REGEX<br> <input type="text" name="email"
													value="${uuser.email}" class="input-xlarge"
													pattern="[^@\s]+@[^@\s]+\.[^@\s]+"
													title="Invalid email address"> <br>
													
													
													<input type="submit" value="UPDATE"><br>
										</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>