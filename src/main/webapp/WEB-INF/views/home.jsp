<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
Hello<br>
<a href="${contextPath}/register/step1">회원가입</a><br>
<a href="${contextPath}/member_temp/edit">회원전용페이지</a>
<c:if test="${empty authInfo}">
	<a href="${contextPath}/login">로그인</a><br>
</c:if>
<c:if test="${not empty authInfo}">
	<a href="${contextPath}/logout">로그아웃</a><br>
</c:if>
<a href="${contextPath}/memberList">회원목록</a>
</body>
</html>