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
	<a href="/worldCup/">home</a>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>�̸�</td>
			<td>����</td>
			<td>���Ƚ��</td>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.name}</td>
			<td><img src="../${item.image}" width="200",height="200"></td>
			<td>${item.win}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>