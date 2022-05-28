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
					$("#id_check").html("��밡���� ���̵� �Դϴ�.")
					IdFlag = 1
				} else {
					$("#id_check").html("���Ұ����� ���̵� �Դϴ�.")
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
			$("#pw_check").html("��й�ȣ�� �ٸ��ϴ�")
			PwFlag = 0
		}
	});
	
	$("#submitBtn").click(function() {
		if (IdFlag==0 ||PwFlag==0){
			alert("���̵� ��й�ȣ�� Ȯ���ϼ���")
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
					alert("ȸ������ ����")
					window.location.href = "/worldCup/login";
				},
				error: function() {
					alert('ȸ������ ����')
				}
			})
		}
	})
})
</script>
</head>
<body>
	<h1>ȸ������</h1>

	<form id="loginForm">
		�̸� : <input type="text" name="name" id="name"><br> ���̵� :
		<input type="text" name="id" id="id"><span id="id_check"></span><br>
		��й�ȣ : <input type="password" name="pw" id="pw"><br> ��й�ȣ
		Ȯ�� : <input type="password" name="pw2" id="pw2"><span
			id="pw_check"></span><br>
		<button type="button" id="submitBtn">ȸ������</button>
	</form>

</body>
</html>