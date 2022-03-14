<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function() {
	var IdFlag = 0
	var PwFlag = 0
	$("#id").change(function() {
		var data = new FormData();
		var id = $("#id").val()
		data.append("id",id)
		console.log(typeof(data));
		$.ajax({
			type: "post",
			url: "checkId",
			contentType: false,
			processData: false,
			data: data,
			
			success: function(data) {
				if(data=="ok"){
					$("#id_check").html("사용가능한 아이디 입니다.")
					IdFlag = 1
				} else {
					$("#id_check").html("사용불가능한 아이디 입니다.")
					IdFlag = 0
				}
			},
			error: function() {
				alert('fail')
			}
		})
	});
	$("#pw2").change(function() {
		if($("#pw").val()==$("#pw2").val()){
			$("#pw_check").html("")
			PwFlag = 1
		} else{
			$("#pw_check").html("비밀번호가 다릅니다")
			PwFlag = 0
		}
	});
	
	$("#submitBtn").click(function() {
		if (IdFlag==0 ||PwFlag==0){
			alert("아이디나 비밀번호를 확인하세요")
		} else{
			var data = $("#loginForm").serialize()
			console.log(data);
			$.ajax({
				type:"post",
				url:"join",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				processData: false,
				data: data,
				success: function() {
					alert("회원가입 성공")
					window.location.href = "/worldCup/login";
				},
				error: function() {
					alert('회원가입 실패')
				}
			})
		}
	})
})
</script>
</head>
<body>
	<h1>회원가입</h1>

	<form id="loginForm">
		이름 : <input type="text" name="name" id="name"><br> 아이디 :
		<input type="text" name="id" id="id"><span id="id_check"></span><br>
		비밀번호 : <input type="password" name="pw" id="pw"><br> 비밀번호
		확인 : <input type="password" name="pw2" id="pw2"><span
			id="pw_check"></span><br>
		<button type="button" id="submitBtn">회원가입</button>
	</form>

</body>
</html>