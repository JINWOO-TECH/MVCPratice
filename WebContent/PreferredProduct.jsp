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
우선 생산 제품
<table  border="1">
	<tr>
		<th>제품코드</th>
		<th>제품이름</th>
		<th>제품원가</th>
		<th>목표수량</th>
		<th>재고수량</th>
		<th>출고가</th>
		<th>그룹코드</th>
	</tr>

	<c:forEach items="${list }" var="list">
	<tr>
		<td>${list.code }</td>
		<td>${list.pname }</td> 
		<td>${list.cost }</td>
		<td>${list.pnum }</td> 
		<td>${list.jnum }</td>
		<td>${list.sale }</td> 
		<td>${list.gcode }</td>
	</tr>
	</c:forEach>
</table>
<a href="main.do">메인화면 </a>
</body>
</html>