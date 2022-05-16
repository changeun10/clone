<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="True" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<img src="/${list[i].ZImage }" width="200",height="200">
		<form action="/worldCup/${id }" method="post">
			<input type="hidden" name ="index" value="${index}">
			<input type="hidden" name ="WorldCup_title" value="${worldCup_title}">
			<input type="hidden" name ="worldCup_id" value="${list[i].worldCupId.id}">
			<input type="hidden" name ="name" value="${list[i].name }">
			<input type="hidden" name ="ZImage" value="${list[i].ZImage }">
			<input type="submit" value="${list[i].name }">
		</form>
		<%-- <a href="/worldCup/${title }?index=${index}&id=${list[i].id}&name=${list[i].name }&ZImage=${list[i].ZImage }&WorldCup_title=${WorldCup_title}"><button>${list[i].name }</button></a><br> --%>
		
		<img src="/${list[i+1].ZImage }" width="200",height="200">
		<form action="/worldCup/${id }" method="post">
			<input type="hidden" name ="index" value="${index}">
			<input type="hidden" name ="WorldCup_title" value="${worldCup_title}">
			<input type="hidden" name ="worldCup_id" value="${list[i+1].worldCupId.id}">
			<input type="hidden" name ="name" value="${list[i+1].name }">
			<input type="hidden" name ="ZImage" value="${list[i+1].ZImage }">
			<input type="submit" value="${list[i+1].name }">
		</form>
		<%-- <a href="/worldCup/${title }?index=${index}&id=${list[i+1].id}&name=${list[i+1].name }&ZImage=${list[i+1].ZImage }&WorldCup_title=${WorldCup_title}"><button>${list[i+1].name }</button></a><br> --%>
		
	</c:when>
	
	<c:otherwise>
		<img src="/${list[0].ZImage }">
		우승: ${list[0].name }<br>
		${list[0].name}
		<a href="/worldCup/statistic/${id}?name=${list[0].name}&WorldCup_title=${WorldCup_title}">통계보기</a>
	</c:otherwise>
</c:choose>
</body>
</html>
