<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add page</title>
<link rel="stylesheet" href="css/todoAdd_style.css">
</head>
<body>
	<header>
		<h1>할일 등록</h1>
	</header>
	<div>
		<form method="post" action="addservlet">
			어떤일인가요?<br> 
			<input class="title" type="text" name="title" maxlength=24 placeholder="swift 공부하기(24자까지)" required><br><br>
			누가 할일인가요?<br> 
			<input class="name" type="text" name="name" placeholder="홍길동" required><br><br>
			우선순위를 선택하세요<br>
			<input type="radio" name="sequence" value=1 required>1순위    
			<input type="radio" name="sequence" value=2 required>2순위    
			<input type="radio" name="sequence" value=3 required>3순위  <br><br><br>
			<a id="back_page" href="mainservlet"> < 이전 </a> 
			<input class="add_button" type="submit" value="제출"> 
			<input class="add_button" type="reset" value="내용 지우기">
		</form>
	</div>
</body>
</html>