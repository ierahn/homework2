<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()"><b class="right">Logout</b></a>
		<br/>
		<hr/>
	</c:if>

	<form id="logout" action="<c:url value='/logout' />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<p><a href="${pageContext.request.contextPath}/semester"> 학년/학기별 이수 총학점 </a></p>
	<p><a href="${pageContext.request.contextPath}/category"> 이수 구분별 학점내역</a></p>
	<p><a href="${pageContext.request.contextPath}/registration"> 2018년도 1학기 수강 신청 </a></p>
	<p><a href="${pageContext.request.contextPath}/newsemester"> 2018년도 1학기 수강 신청 조회 </a></p>

</body>
</html>