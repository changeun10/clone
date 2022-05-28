<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="TextValue" value="010-abcd-1234"/> 

<form action="test" method="post">
	<input type="hidden" name="a" value=[1,2,3]>
	<input type="submit">
</form>
<form>
<input type="text" list="Language">
<datalist id="Language">
    <option value="Java">
    <option value="HTML">
    <option value="CSS">
</datalist>
</form>
</body>
</html>