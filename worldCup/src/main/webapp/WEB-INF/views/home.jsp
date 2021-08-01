<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="True" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>이상형월드컵!</h1>
<a href="/worldCup/?type=0">인기순</a>  <a href="/worldCup/?type=1">최신순</a>    <a href="/worldCup/create">이상형 월드컵 만들기</a><br>
<br>
	<c:forEach items="${list}" var="item">
		<h3>${item.des }</h3>
		<img src="${item.thumb_image }">
		<form action="/worldCup/${item.title }" method="get">
			<select name="round">
				<option value="8">8</option>
				<option value="16">16</option>
			</select>강
			<input type="hidden" name="WorldCup_title" value=${item.des }>
			<input type="submit" value="시작">
		</form>
		<br>
	</c:forEach>
	

</body>
</html>
