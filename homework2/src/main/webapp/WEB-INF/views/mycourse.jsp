<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mycourse</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>수강년도</th>
				<th>학기</th>
				<th>교과코드</th>
				<th>교과목명</th>
				<th>구분</th>
				<th>학점</th>
			</tr>
		</thead>

		<c:forEach var="mycourse" items="${mycourse}">
			<tr>
				<td><c:out value="${mycourse.year}">
					</c:out></td>
				<td><c:out value="${mycourse.semester}">
					</c:out></td>
				<td><c:out value="${mycourse.code}">
					</c:out></td>
				<td><c:out value="${mycourse.name}">
					</c:out></td>
				<td><c:out value="${mycourse.category}">
					</c:out></td>
				<td><c:out value="${mycourse.credits}">
					</c:out></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>