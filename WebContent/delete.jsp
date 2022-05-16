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
<h1>제품번호 : ${param.code }를 <br>
<c:if test="${count==1  }">삭제를 성공했습니다.</c:if>
<c:if test="${count!=1  }">삭제를 실패했습니다zz.</c:if>
</h1>
<a href="main.do">돌아가기</a>
</body>
</html>