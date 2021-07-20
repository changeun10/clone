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
	<table width ="500" cellpadding="0" cellspacing="0" boarder="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.bid }</td>
			<td>${dto.bname }</td>
			<td>
				<c:forEach begin="1" end="${dto.bindent }">-</c:forEach>
				<a href="content_view?bid=${dto.bid}">${dto.btitle }</a>
			</td>
			<td>${dto.bdate }</td>
			<td>${dto.bhit }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
	</table>
</body>
</html>

