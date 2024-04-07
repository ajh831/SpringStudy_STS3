<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

/* Style the body */
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

/* Header/logo Title */
.header {
	padding: 40px;
	text-align: center;
	background: #1abc9c;
	color: white;
}

/* Increase the font size of the heading */
.header h1 {
	font-size: 40px;
}

/* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
.navbar {
	overflow: hidden;
	background-color: #333;
	position: sticky;
	position: -webkit-sticky;
	top: 0;
}

/* Style the navigation bar links */
.navbar a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
	float: right;
}

/* Change color on hover */
.navbar a:hover {
	background-color: #ddd;
	color: black;
}

/* Active/current link */
.navbar a.active {
	background-color: #666;
	color: white;
}

/* Column container */
.row {
	display: -ms-flexbox; /* IE10 */
	display: flex;
	-ms-flex-wrap: wrap; /* IE10 */
	flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
	-ms-flex: 30%; /* IE10 */
	flex: 30%;
	background-color: #f1f1f1;
	padding: 20px;
}

/* Main column */
.main {
	-ms-flex: 70%; /* IE10 */
	flex: 70%;
	background-color: white;
	padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Footer */
.footer {
	padding: 20px;
	text-align: center;
	background: #ddd;
}

.container {
	text-align: center; /* 텍스트 가운데 정렬 */
	margin: 0 auto; /* 수평 중앙 정렬 */
}

table {
	border-collapse: collapse;
	width: 100%;
	border-top: 2px solid rgb(39, 39, 39);
}

tr:nth-child(even) {
	background-color: #f0f0f070;
}

th, td {
	width: 300px;
	text-align: center;
	padding: 10px 12px;
	border-bottom: 1px solid #ddd;
}

td {
	color: rgb(53, 53, 53);
}

.no {
	width: 150px;
}

.title {
	width: 50%;
}

td.title {
	text-align: left;
}

td.writer {
	text-align: left;
}

td.viewcnt {
	text-align: right;
}

td.title:hover {
	text-decoration: underline;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
	.row {
		flex-direction: column;
	}
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
	.navbar a {
		float: none;
		width: 100%;
	}
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div class="header">
		<h1>My Website</h1>
		<p>
			A <b>responsive</b> website created by me.
		</p>
	</div>

	<jsp:include page="../menue.jsp" flush="false" />
	<div class="board-container">
		<form action="/board/insert" method="post">
 			제목 : <input type="text" style="width:100%;" name="title" placeholder="제목을 입력하세요" value="${Board.title}"><br><br>
    		내용 : <br><textarea rows="20" style="width:100%;" name="content" placeholder="내용을 입력하세요">${Board.content}</textarea><br>
			<input type="submit" value="등록">
		</form>
	</div>

	<div class="footer">
		<h2>Footer</h2>
	</div>
</body>
</html>