<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/dorequest"
		modelAttribute="course">
		<!-- name을 동일하게 해야 바인딩이 제대로 이루어 진다. -->
		<table class="formtable">
			<tr>
				<td class="label">교과코드 :</td>
				<td><sf:input class="control" type="text" path="course_code" /> <br />
					<sf:errors path="course_code" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과목명 :</td>
				<td><sf:input class="control" type="text" path="course_name" /> <br />
					<sf:errors path="course_name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">구분 :</td>
				<td><sf:input class="control" type="text" path="classification" /> <br />
					<sf:errors path="classification" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td><sf:input class="control" type="text" path="credit" /> <br />
					<sf:errors path="credit" class="error" /></td>
			</tr>
			<tr>
				<td colspan=2 class="control"><input type="submit" value="신청" /></td>
			</tr>
		</table>

	</sf:form>

</body>
</body>
</html>