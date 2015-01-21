<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<body>
<h1>회원가입</h1>
<form action="update.do" method="post" 
    enctype="multipart/form-data">
아이디:<input name="id" type="text" 
          placeholder="아이디를 입력하세요. ex)test1004"><br>
암호:<input name="password" type="password" 
          placeholder="암호를 입력하세요."><br>
암호확인:<input type="password" 
          placeholder="확인차 암호를 다시 입력하세요."><br>
이메일:<input name="email" type="email" 
          placeholder="이메일을 입력하세요"><br>
사진:<input name="file" type="file"><br> 
<img src="../files/photo_1421825550937"><br>         
<button type="submit">확인</button>
<button type="button">취소</button>
</form>
</body>

</html>