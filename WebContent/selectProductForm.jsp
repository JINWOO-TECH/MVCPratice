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
<script>
	function sel(){
		var temp = document.getElementById("code").value
		if(temp.length>0){
			form1.action="select.do";
		}
		else{
			alert("제품코드를  입력해 주세요. ");
		}
	}
	
	function del(){
		form1.action="delete.do";	
		}
	
	function update(){
		form1.action="update.do";
	}
	
	function block(){
        var input = document.getElementById("code");
		if(document.getElementById("code").value){
			// input엘리먼트에 disbled="disabled" 속성 추가한다.
	        input.setAttribute("disabled", "disabled");
		}
     
	}
</script>
</head>
<body>
<h1>생산관리 조회 & 수정화면</h1>
생산관리 조회화면
<div class="mainbox">
	<form action="" method="post" name="form1">
	<ul>
		<li> 제품코드 <input type="text" id="code" name="code" value="${product.code }" onclick="block()" >
		<li> 제품이름 <input type="text" id="pname" name="pname" value="${product.pname }">
		<li> 제품원가 <input type="number" id="cost" name="cost" value="${product.cost }">
		<li> 목표수량 <input type="number" id="pnum" name="pnum" value="${product.pnum }">
		<li> 제고수량 <input type="number" id="jnum" name="jnum" value="${product.jnum }">
		<li> 출고가 <input type="text" id="sale" name="sale" value="${product.sale }">
		<li> 그룹이름 <select name="gcode" id="gcode">
					<c:forEach items="${groupCode }" var="i">
						<option value="${i.gcode }">${i.gname }</option>
					</c:forEach>
					</select>
	</ul>
	<input class="submit" type="submit" value="조회" onclick="sel()">
	<input class="submit" type="submit" value="수정" onclick="update()">
	<input class="submit" type="submit" value="삭제" onclick="del()">
	<button class="submit" type="button" onclick="location.href='main.html';">메인화면</button>
	</form>
</div>
</body>
</html>