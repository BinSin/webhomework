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
		<c:forEach var="credit" items="${credit}">
			<td class="label">${credit.classification}</td>
		</c:forEach>
		<td class="label">총학점</td>
		</tr>
		<tr>
		<c:forEach var="credit" items="${credit}">
			<td class="label">${credit.credit}</td>
		</c:forEach>
		<td class="label">${totalCredit}</td>
		</tr>

	</table>
</body>
</html>