$(document).ready(function () {
	  $("#btnUpload").click(function () {
		event.preventDefault(); 
		
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
	function onChange(event) {
				for (var image of event.target.files) {
					var reader = new FileReader();
					reader.onload = function(event) {
						var div = document.createElement("div");
						
							var img = document.createElement("img"); 
							img.setAttribute("src", event.target.result); 
							img.setAttribute("width", "100px");
							img.setAttribute("height", "100px");
							
							var input = document.createElement("input");
							input.setAttribute("type","text");
							input.setAttribute("name","name");
							input.setAttribute("size","10");
							
							var btn = document.createElement("button");
							btn.setAttribute("onclick","onClick(this.parentNode)")
							btn.setAttribute("type","button")
							btn.innerHTML = "삭제";
							
							
						div.appendChild(img);
						div.appendChild(input);
						div.appendChild(btn);
						div.appendChild(document.createElement("br"));
						document.querySelector("div#image_container").appendChild(div);
			        };
			        reader.readAsDataURL(image);
				}
			}
			function onClick(event) {
				console.log(event);
				event.remove();
				var files = document.querySelector("#image").files;
				console.log(Object.keys(files));
				console.log(delete files["0"])
				console.log(files);
			}