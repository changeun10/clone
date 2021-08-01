<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>이상형월드컵 만들기!</h1>
	<form action="createWorldCup" method="post" enctype="multipart/form-data">
	썸네일로 사용할 사진을 선택해주세요<br> : <input type="file" name="thumb" ><br>
	
	제목:<input type="text" name="des"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input type="text" name="name"><br>
	<input multiple="multiple" type="file" name="file" placeholder="파일 선택" /><br />
	<input type="submit">
</form>
</body>
</html>