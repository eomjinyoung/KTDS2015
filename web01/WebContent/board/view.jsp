<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body><h1>게시물 상세보기</h1>
<c:choose>
<c:when test="${board != null}">
	<form action='update' method='post'>
	   번호:<input name='no' type='text' readonly value='${board.no}'><br>
	   제목:<input name='title' type='text' value='${board.title}'><br>
	   내용:<textarea name='contents'>${board.contents}</textarea><br>
	   조회수: ${board.count}<br>
	   등록일: ${board.createDate}<br>
	  <button type='submit'>변경</button>
	  <button type='button' onclick='onDelete(${board.no})'>삭제</button>
	  <button type='button'>취소</button>
	</form>
	<script>
	  function onDelete(no) {
	    location.href = 'delete?no=' + no;
	  }
	</script>
</c:when>
<c:otherwise>
  <p>존재하지 않는 게시물입니다.</p>
</c:otherwise>
</c:choose>
</body></html>














