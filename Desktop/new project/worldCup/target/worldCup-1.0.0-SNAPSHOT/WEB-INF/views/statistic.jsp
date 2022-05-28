<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="/worldCup/">home</a>
	<a href="/worldCup/board?id=${id }&name=${name}">게시판</a>
	
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>이름</td>
			<td>사진</td>
			<td>우승횟수</td>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.name}</td>
			<td><img src="/${item.ZImage}" width="200",height="200"></td>
			<td>${item.win}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>