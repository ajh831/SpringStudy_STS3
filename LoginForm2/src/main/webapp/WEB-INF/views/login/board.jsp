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
		<div class="search-container">
			<form action="<c:url value="/board/list"/>" class="search-form"  style="float: right;"
				method="get">
				<%-- <select class="search-option" name="option">
					<option value="A"
						${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
					<option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
					<option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
				</select> <input type="text" name="keyword" class="search-input" type="text"
					value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요"> <input
					type="submit" class="search-button" value="검색"> --%>
			</form><br><br>
			<button id="writeBtn" class="btn-write" style="float: right;"
				onclick="location.href='<c:url value="/board/write"/>'">
				<i class="fa fa-pencil"></i> 글쓰기
			</button>
		</div>
		<table>
			<tr>
				<th class="no">번호</th>
				<th class="title">제목</th>
				<th class="writer">이름</th>
				<th class="regdate">등록일</th>
				<th class="viewcnt">조회수</th>
			</tr>
			<c:forEach var="Board" items="${boardList}">
				<tr>
					<td>${Board.bno}</td>
					<%-- <td>${Board.title}</td> --%>
					<td class="title"><a href="<c:url value='/board/read?bno=${Board.bno}'/>">${Board.title}</a></td>
					<td>${Board.writer}</td>
					<c:choose>
						<c:when test="${Board.reg_date.time >= startOfToday}">
							<td class="regdate"><fmt:formatDate
									value="${Board.reg_date}" pattern="HH:mm" type="time" /></td>
						</c:when>
						<c:otherwise>
							<td class="regdate"><fmt:formatDate
									value="${Board.reg_date}" pattern="yyyy-MM-dd" type="date" /></td>
						</c:otherwise>
					</c:choose>
					<td>${Board.view_cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 여기에 Paging한거 작성 -->
		
	</div>

	<div class="footer">
		<h2>Footer</h2>
	</div>
	<script>
		$("#writeBtn").on("click", function() {
			let form = $("#form");
			form.attr("action", "<c:url value='/board/write'/>");
			form.attr("method", "post");

			if (formCheck())
				form.submit();
		});
	</script>
</body>
</html>