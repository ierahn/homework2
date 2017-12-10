<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="course">
		<table class="formtable">
			<tr> <td class="lable"> �����⵵ : </td> <td> <input class="control" type="text" name="year"/> <br/> </td> </tr>
			<tr> <td class="lable"> �б� : </td> <td> <input class="control" type="text" name="semester"/> <br/></td> </tr>
			<tr> <td class="lable"> �����ڵ� : </td> <td> <input class="control" type="text" name="code"/> <br/></td> </tr>
			<tr> <td class="lable"> ������� : </td> <td> <input class="control" type="text" name="name"/> <br/></td> </tr>
			<tr> <td class="lable"> ���� : </td> <td> <input class="control" type="text" name="category"/> <br/></td> </tr>
			<tr> <td class="lable"> ���� : </td> <td> <input class="control" type="text" name="credits"/> <br/></td> </tr>
			<tr> <td class="label"> </td> <td> <input class="control" type="submit" value="������û"/> </td> </tr>
			
		</table>
	</sf:form>
<%-- 
	<sf:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="course">
		<table class="formtable">
			<tr> <td class="label"> �����⵵ : </td> <td> <sf:input class="control" type="text" path="year"/> <br/> </td> </tr>
			
			<tr> <td class="label"> �б� : </td> <td> <sf:input class="control" type="text" path="semester"/> <br/></td> </tr>
			
			<tr> <td class="label"> �����ڵ� : </td> <td> <sf:textarea class="control" type="text" path="code"/> <br/>
			<sf:errors path="code" class="error"/> </td> </tr>
			
			<tr> <td class="label"> ������� : </td> <td> <sf:textarea class="control" type="text" path="name"/> <br/>
			<sf:errors path="name" class="error"/> </td> </tr>
			
			<tr> <td class="label"> ���� : </td> <td> <sf:textarea class="control" type="text" path="category"/> <br/>
			<sf:errors path="category" class="error"/></td> </tr>
			
			<tr> <td class="label"> ���� : </td> <td> <sf:textarea class="control" type="text" path="credits"/> <br/></td> </tr>
			
			<tr> <td class="label"> </td> <td> <input class="control" type="submit" value="������û"/> </td> </tr>
			
		</table>
	</sf:form>
--%>
</body>
</html>