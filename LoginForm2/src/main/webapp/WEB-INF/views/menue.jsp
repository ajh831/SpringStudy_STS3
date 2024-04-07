<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="sessionId" value="${sessionScope.id}" />
<c:set var="loginMenu">
    <c:choose>
        <c:when test="${not empty sessionId}">
            <a href='/login/logout' class='right'>LogOut</a>
            <a href='#' class='right'><c:out value="${sessionId}" /></a>
        </c:when>
        <c:otherwise>
            <a href='/login' class='right'>Login</a>
            <a href='/registerForm' class='right'>회원가입</a>
        </c:otherwise>
    </c:choose>
</c:set>

<div class="navbar">
    <a href="/" class="active">Home</a>
    <a href="/login/board">게시판</a>
    <a href="/news">보도자료</a>
    <a href="/login/qna">문의사항</a>
    <c:out value="${loginMenu}" escapeXml="false" />
</div>
