<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body><h1>게시물 목록(OTL)</h1>
<table>
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>조회수</th>
  <th>등록일</th>
</tr> 

<c:forEach var="board" items="${list}"> 
<tr>
  <td>${board.no}</td>
  <td><a href='view?no=${board.no}'>${board.title}</a></td>
  <td>${board.count}</td>
  <td>${board.createDate})</td>
</tr>
</c:forEach>

</table>
<a href='form.html'>글쓰기</a><br>
</body></html>








