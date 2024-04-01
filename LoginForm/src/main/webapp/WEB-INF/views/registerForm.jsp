<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

#register {
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
	<form:form modelAttribute="user" action="/registerInfo" method="get">
		<div class="container">
			<div style="text-align: center; font-size: 40px">회원가입</div>
			<label for="uid"><b>id : </b></label><input type="text" name="id"><br>
			<label for="psw"><b>pwd : </b></label><input type="password" name="pwd" placeholder="영문자,숫자, 특수문자를 조합하여 8자 이상"><br>
			<label for="uname"><b>이름 : </b></label><input type="text" name="uName"><br>
			<label for="birth"><b>생년월일 : </b></label><input type="date" name="birth"><br>
			<label for="uaddress"><b>주소 : </b></label><input type="text" name="address"><br>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<!--<input type="submit" value="로그인">-->
			<button id="register" type="submit">가입하기</button>
		</div>
	</form:form>
	<div class="container" style="background-color: #f1f1f1">
		<button id="back" onClick="location.href='/'">돌아가기</button>
	</div>
	<script>
		
	</script>
</body>
</html>