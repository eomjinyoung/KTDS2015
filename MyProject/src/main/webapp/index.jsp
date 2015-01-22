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
<div>
<c:choose>
  <c:when test="${empty loginInfo}">
    <a href="member/login.html">로그인</a>
  </c:when>
  <c:otherwise>
		<img style="width:20px; height:20px;" 
		    src="files/${loginInfo.photo}">
		${loginInfo.id}(${loginInfo.email})
		<a href="member/logout.do">로그아웃</a>  
  </c:otherwise>
</c:choose>
</div>
<h1>안녕하세요.2</h1>
</body>
</html>








