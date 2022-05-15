<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/js/create.js"></script>
</head>
<body>
	<a href="/worldCup/">홈으로</a>
	<h1>이상형월드컵 만들기!</h1>
	<form enctype="multipart/form-data" id="uploadForm">
	
	썸네일로 사용할 사진을 선택해주세요 : <input type="file" id="thumb" ><br>
	
	제목:<input type="text" name="des"><br>
	<input multiple="multiple" type="file" name="file" id="image" />
	<div id="image_container"></div>
	<button type="button" id='btnUpload'>만들기</button>
</form>
<div id="image_container"></div>

</body>
</html>