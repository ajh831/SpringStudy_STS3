<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%

	String toURL = request.getParameter("toURL");

	System.out.println("loingForm toURL : " + toURL);
	String checkInfo = null;
	String cookieId = "";

	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		System.out.println("COOKIES LENGTH : "+cookies.length);
		System.out.println("Cookies != null 쿠키 있음 " + cookies);
		for (Cookie cookie : cookies) {
			System.out.println("Cookies for 문 도는 중 : " + cookie.getName());
			if (cookie.getName().equals("cookieId")) {
				System.out.println("cookieId 쿠키 있음");
				checkInfo = "checked";
				break;
			}
		}
	}
	
	System.out.println("checkInfo : " + checkInfo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* Bordered form */
form {
	border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
	opacity: 0.8;
}

#login {
	background-color: #04AA6D;
}

/* Extra style for the cancel button (red) */
#back {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
	width: 40%;
	border-radius: 50%;
}

/* Add padding to containers */
.container {
	padding: 16px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form action="/login/login" method="post">
		<div class="container">
			<label for="uname"><b>id : </b></label><input type="text" name="id" value="${cookie.cookieId.value}"><br>
			<label for="psw"><b>pwd : </b></label><input type="password" name="pwd"><br>
			<label for="remember"> <input id="rememebr" type="checkbox" name="checkBox" <%=checkInfo%>> id 저장</label><br>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<!--<input type="submit" value="로그인">-->
			<button id="login" type="submit">로그인</button>
		</div>
		<input name="toURL" type="text" value=<%=toURL%>>
	</form>
	<div class="container" style="background-color: #f1f1f1">
		<button id="back" onClick="location.href='/'">돌아가기</button>
	</div>
	<script>
		let rememebr = document.getElementById("rememebr");
		window.onload = function() {
			rememebr.onclick = question;
		}
		
		let question = function () {
			if(rememebr.checked != false) {
				confirm("id를 저장하시겠습니까?");
			} else {
				confirm("id 저장을 취소하시겠습니까?");
			}
		}
		
	</script>
</body>
</html>