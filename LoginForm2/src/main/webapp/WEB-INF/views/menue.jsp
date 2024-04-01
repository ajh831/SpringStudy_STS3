<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionId = (String) session.getAttribute("id");
	String loginMenue = "";
	if(sessionId != null) {
		loginMenue = "<a href='/login/logout' class='right'>LogOut</a><a href='#' class='right'>" + sessionId + "</a>";    		
	} else {
		loginMenue = "<a href='/login' class='right'>Login</a><a href='/registerForm' class='right'>회원가입</a>";
	}
	
%>
<div class="navbar">
	<a href="/" class="active">Home</a>
	<a href="/login/board">게시판</a>
	<a href="/news">보도자료</a>
	<a href="/login/qna">문의사항</a>
  <%=loginMenue%>
</div>