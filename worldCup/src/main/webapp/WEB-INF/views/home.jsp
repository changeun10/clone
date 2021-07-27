<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="True" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
축구선수 이상형 월드컵
<form action="/worldCup/soccer_player" method="get">
	<select name="round">
		<option value="8">8</option>
		<option value="16">16</option>
	</select>
	<input type="submit" value="시작">
</form>

음식 이상형 월드컵
<form action="/worldCup/food" method="get">
	<select name="round">
		<option value="8">8</option>
		<option value="16">16</option>
	</select>
	<input type="submit" value="시작">
</form>
</body>
</html>
