<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
그룹별 재고 수량
<table  border="1">
	<tr>
		<th>그룹코드</th>
		<th>제고수량 합</th>
	</tr>

	<c:forEach items="${list }" var="list">
	<tr>
		<td>${list.code }</td>
		<td>${list.jnum }</td>
	</tr>
	</c:forEach>
</table>
<a href="main.do">메인화면 </a>
</body>
</html>