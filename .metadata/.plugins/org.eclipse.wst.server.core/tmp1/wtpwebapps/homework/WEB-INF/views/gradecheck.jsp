<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<table class="formtable">
		<tr>
			<td class="label">년도</td>
			<td class="label">학기</td>
			<td class="label">이수 학점</td>
			<td class="label">상세보기</td>
		</tr>
		<c:forEach var="course" items="${courses}" >
		<c:forEach var="credit" items="${credits}" >
		<tr>
			<td class="label">${course.year}</td>
			<td class="label">${course.semester}</td>
			<td class="label">${credit}</td>
			<td class="label"><a href="${pageContext.request.contextPath}/detail">링크</a></td>
		</tr>
		</c:forEach>
		</c:forEach>
	</table>
</body>
</html>