<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="css/main_style.css?ver=1">
</head>
<body>
	<header>
		<h1>나의 해야할 일들!</h1>
		<a href=addform><button>새로운 TODO 등록</button></a>
	</header>
	<div class="board">
		<div class="todo" id="TODO">
			<section class="titlebox">
				<h1>TODO</h1>
			</section>
			<c:forEach items="${todolist}" var="todo">
				<section class="box" id="${todo.id}">
					<button class="button" id="b${todo.id}"
						onclick="update(${todo.id})">→</button>
					<h1>${todo.title}</h1>
					등록날짜:${todo.regDate}, ${todo.name}, 우선순위 ${todo.sequence}
				</section>
			</c:forEach>
		</div>

		<div class="doing" id="DOING">
			<section class="titlebox">
				<h1>DOING</h1>
			</section>
			<c:forEach items="${doinglist}" var="doing">
				<section class="box" id="${doing.id}">
					<button class="button" id="b${doing.id}"
						onclick="update(${doing.id})">→</button>
					<h1>${doing.title}</h1>
					등록날짜:${doing.regDate}, ${doing.name}, 우선순위 ${doing.sequence}
				</section>
			</c:forEach>
		</div>

		<div class="done" id="DONE">
			<section class="titlebox">
				<h1>DONE</h1>
			</section>
			<c:forEach items="${donelist}" var="done">
				<section class="box" id="box1">
					<h1>${done.title}</h1>
					등록날짜:${done.regDate}, ${done.name}, 우선순위 ${done.sequence}
				</section>
			</c:forEach>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/main.js?ver=2"></script>
</html>