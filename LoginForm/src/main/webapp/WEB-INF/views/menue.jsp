<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionId = (String) session.getAttribute("id");
	String loginMenue = "";
	if(sessionId != null) {
		loginMenue = "<a href='/LogoutServlet' class='right'>LogOut</a><a href='#' class='right'>" + sessionId + "</a>";    		
	} else {
		loginMenue = "<a href='/loginForm' class='right'>Login</a>";
	}
	
%>
<div class="navbar">
  <a href="/" class="active">Home</a>
   <a href="/login/board">게시판</a>
   <a href="/login/qna">문의사항</a>
  <a href="/userInfo">userInfo</a>
  <%=loginMenue%>
</div>