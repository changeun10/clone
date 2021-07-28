<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/worldCup/">홈으로</a>
	<form action="/worldCup/write" method="post">
		댓글작성<br><input type="hidden" name="title" value="${title }">
		<input type="hidden" name="name" value="${name }">
		내용: <input type="text" name="content">
		<input type="submit" value="작성">
	</form>

	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<tr>
				<td>내가 뽑은 1등</td>
				<td width="500">내용</td>
			</tr>
		<c:forEach items="${list}" var="item">
			
			<tr>
				<td>${item.name}</td>
				<td>${item.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>