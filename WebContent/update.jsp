<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<h1>제품번호 : ${param.code }를 <br>
제품이름 :${param.pname }, 제품원가 : ${param.cost }, 목표수량 : ${param.pnum },<br>>
재고수량 : ${param.jnum }, 출고가 : ${param.sale }, 그룹코드 : ${param.gcode } 로
<c:if test="${count==1  }">수정에 성공했습니다.</c:if>
<c:if test="${count!=1  }">수정에 실패했습니다.</c:if>
</h1>
<a href="main.do">돌아가기</a>
</body>
</html>