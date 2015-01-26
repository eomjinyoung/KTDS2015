<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>게시물 목록(OTL)</h1>
<table class="table table-hover">
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>조회수</th>
  <th>등록일</th>
</tr> 

<c:forEach var="board" items="${list}"> 
<tr>
  <td>${board.no}</td>
  <td><a href='view.do?no=${board.no}'>${board.title}</a></td>
  <td>${board.count}</td>
  <td>${board.createDate})</td>
</tr>
</c:forEach>

</table>

<c:if test="${pageNo > 1}">
<a href="list.do?pageNo=${pageNo - 1}" 
    class="btn btn-default">이전</a>
</c:if>
<c:if test="${pageNo < totalPage}">
<a href="list.do?pageNo=${pageNo + 1}" 
    class="btn btn-default">다음</a>
</c:if>
<a href='form.html' class="btn btn-primary">글쓰기</a><br>
</div><!-- container div -->
</body></html>








