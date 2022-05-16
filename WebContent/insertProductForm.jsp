<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.mainbox{ border:1px solid; border-style:"groove"; border-color:#EAEAEA;padding:20px; }
	button{  margin: 10px; width:150px ;height:50px ;font-size:large; background-color:#FAF4C0 }
	input{margin:10px;padding: 3px}
	.submit{margin: 10px; width:100px ;height:30px ; background-color:#FAF4C0;font-size:medium;}
</style>
</head>
<body>
<h1>생산관리 등록화면</h1>
생산관리 등록화면
<div class="mainbox">
	<form action="insert.do" method="post">
	<ul>
		<li> 제품코드 <input type="text" name="code" required>
		<li> 제품이름 <input type="text" name="pname" required>
		<li> 제품원가 <input type="number" name="cost">
		<li> 목표수량 <input type="number" name="pnum">
		<li> 제고수량 <input type="number" name="jnum">
		<li> 출고가 <input type="text" name="sale">
		<li> 그룹이름 <select name="gcode">
					<c:forEach items="${groupCode }" var="i">
						<option value="${i.gcode }">${i.gname }</option>
					</c:forEach>
					</select>
	</ul>
	<input class="submit" type=submit value="등록">
	<button class="submit" type="button" onclick="location.href='main.html';">메인화면</button>
	</form>

</div>
</body>
</html>