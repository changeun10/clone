<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="/worldCup/">홈으로</a>
내가 만든 월드컵

	<c:forEach items="${list}" var="item">
		${item.id }
		<h3>${item.title }</h3>
		<img src="/${item.thumb_img }">
		<form action="/worldCup/${item.title }" method="get">
			<select name="round">
				<option value="8">8</option>
				<option value="16">16</option>
			</select>강
			<input type="hidden" name="WorldCup_title" value=${item.title }>
			<input type="submit" value="시작">
		</form>
		
		<a href="delete?id=${item.id }&title=${item.title }">삭제</a>
		<br>
	</c:forEach>
</body>
</html>