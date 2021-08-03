<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"> 
$(document).ready(function () {
	  $("#btnUpload").click(function () {
		
		var form = $('#uploadForm')[0];
		
		var get_des = $("input[name=des]")
		console.log(get_des.val());
		
		
		var get_input = $("input[name=name]")
		var data = new FormData();
		data.append("des",get_des.val());
		$.each(get_input, function (index, value) {
			data.append("value",$(value).val())
			});
		
		
		for(var i=0;i<form.image.files.length;i++) {
			var k = form.image.files[i];
			data.append("image",k)
		}

	    
		for (var key of data.keys()) {
		    console.log(key);
		  }
		  for (var value of data.values()) {
		    console.log(value);
		  }
		  
		$.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
	        url: "/worldCup/test",
	        data: data,
	        processData: false,
	        contentType: false,
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	$('#btnUpload').prop('disabled', false);
	        	alert('success')
	        },
	        error: function (e) {
	            $('#btnUpload').prop('disabled', false);
	            alert('fail');
	        }
	    });
	  });
	});   	
</script>
</head>
<body>
	
	<form enctype="multipart/form-data" id="uploadForm">
		<input type="text" name="des">
		<input multiple="multiple" type="file" name="file" id="image" /> 
		<input type="text" name="name" value="45"><br> 
		<input type="text" name="name" value="55">
		<button type="button" id='btnUpload'>확인</button>
	</form>
</body>
</html>