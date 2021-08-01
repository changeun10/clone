<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="True" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${WorldCup_title } 이상형월드컵
</h1>
<c:choose>
	<c:when test="${list.size()>1 }">
		<c:choose>
			<c:when test="${length eq 2 }">
				결승<br>
			</c:when>
			<c:otherwise>
				${length }강	<br>
			</c:otherwise>
		</c:choose>
	
		<c:set var="i" value="${index }"/>
		<img src="${list[i].image }" width="200",height="200">
		<a href="/worldCup/${title }?index=${index}&id=${list[i].id}&name=${list[i].name }&image=${list[i].image }&WorldCup_title=${WorldCup_title}"><button>${list[i].name }</button></a><br>
		<img src="${list[i+1].image }" width="200",height="200">
		<a href="/worldCup/${title }?index=${index}&id=${list[i+1].id}&name=${list[i+1].name }&image=${list[i+1].image }&WorldCup_title=${WorldCup_title}"><button>${list[i+1].name }</button></a><br>
		
	</c:when>
	<c:otherwise>
		<img src="${list[0].image }">
		우승: ${list[0].name }<br>
		<a href="/worldCup/statistic/${title}?id=${list[0].id}&name=${list[0].name}&WorldCup_title=${WorldCup_title}">통계보기</a>
	</c:otherwise>
</c:choose>
</body>
</html>
