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
			<td class="label">교과코드</td>
			<td class="label">교과목명</td>
			<td class="label">구분</td>
			<td class="label">학점</td>
		</tr>
		<c:forEach var="course" items="${courses}">
			<tr>
				<td class="label">${course.course_code}</td>
				<td class="label">${course.course_name}</td>
				<td class="label">${course.classification}</td>
				<td class="label">${course.credit}</td>
			</tr>
		</c:forEach>

	</table>

	<p> <a href="${pageContext.request.contextPath}/requestcourse"> 수강 신청하기 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/"> 홈으로 </a> </p>
</body>
</html>