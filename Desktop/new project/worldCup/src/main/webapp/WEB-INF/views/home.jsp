<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="True"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>이상형월드컵!</h1>

	<a href="/worldCup/?type=0">인기순</a>
	<a href="/worldCup/?type=1">최신순</a>
	<a href="/worldCup/create">이상형 월드컵 만들기</a>
	<br>
	<c:choose>
		<c:when test="${id eq null}">
			<a href="login">로그인하러가기</a>
		</c:when>
		<c:otherwise>
        ${id }님 안녕하세요 <a href="logout">로그아웃</a>
			<a href="myWorldCup">내가 만든 월드컵</a>
		</c:otherwise>
	</c:choose>
	
	<form action="/worldCup/search" method="get">
		<input type ="text" name = "keyword">
		<input type = "submit" value = "찾기">
	</form> 
	<br>
	<c:forEach items="${list}" var="item">
		<h3>${item.title }</h3>
		<img src="/${item.thumb_img }">
		<form action="/worldCup/${item.id }" method="get">
			<select name="round">
				<option value="8">8</option>
				<option value="16">16</option>
			</select>강 <input type="hidden" name="WorldCup_title" value=${item.title }>
			<input type="submit" value="시작">
		</form>
		<br>
	</c:forEach>


</body>
</html>
