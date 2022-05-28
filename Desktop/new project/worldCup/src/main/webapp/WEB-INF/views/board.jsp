<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="/worldCup/">홈으로</a>
	<form action="/worldCup/write" method="post">
		댓글작성<br><input type="hidden" name="wid" value="${id }">
		<input type="hidden" name="name" value="${name }">
		내가 뽑은 1등: ${name }
		작성자 : <input type="text" name="writer" size="10">
		내용: <input type="text" name="content">
		<input type="submit" value="작성">
	</form>

	<table width="100%" cellpadding="0" cellspacing="0" border="1">
		<thead>
		<tr>
				<td>내가 뽑은 1등</td>
				<td>내용</td>
				<td>작성자</td>
				<td>작성날짜</td>
			</tr>	
		</thead>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.content }</td>
				<td>${item.writer }</td>
				<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>