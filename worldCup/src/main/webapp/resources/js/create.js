$(document).ready(function() {
	$(document).on("change", "#image", function(event) {
		const fileArr = Array.from(event.target.files)
		var i = 0;
		const multipleContainer = document.getElementById("image_container")
        const $colDiv1 = document.createElement("div")
        
        fileArr.forEach((file, index) => {
            const reader = new FileReader()
            const $imgDiv = document.createElement("div") 
			$imgDiv.setAttribute("class",i)
			i=i+1  
            const $img = document.createElement("img")
			$img.setAttribute("width", "100px");
			$img.setAttribute("height", "100px");

			var input = document.createElement("input");
			input.setAttribute("type", "text");
			input.setAttribute("name", "name");
			input.setAttribute("size", "10");

			var btn = document.createElement("button");
			btn.setAttribute("name", "deleteButton")
			btn.setAttribute("type", "button")
			btn.innerHTML = "삭제";
			

            $imgDiv.appendChild($img)
            
			$imgDiv.appendChild(input)
			$imgDiv.appendChild(btn)
            reader.onload = e => {
                $img.src = e.target.result
            }
            
            $colDiv1.appendChild($imgDiv)
            reader.readAsDataURL(file)
        })
        multipleContainer.appendChild($colDiv1)
	});

	var deletArray = new Array();
	$(document).on("click", "button[name='deleteButton']", function(event) {
		
		deletArray.push(Number(event.target.parentNode.className))
		event.target.parentNode.remove()
		
	});
	
	$("#btnUpload").click(function() {
		event.preventDefault();

		var data = new FormData();
		var get_des = $("input[name=des]")
		data.append("des", get_des.val());
		var get_input = $("input[name=name]")
		
		$.each(get_input, function(index, value) {
			data.append("name", $(value).val())
		});
		
		var form = $('#uploadForm')[0];
		data.append("thumb", form.thumb.files[0])
		for (var i = 0; i < form.image.files.length; i++) {
			if (!deletArray.includes(i)){
				var k = form.image.files[i];
				data.append("image", k)	
			}
		}

		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url: "/worldCup/createWorldCup",
			data: data,
			processData: false,
			contentType: false,
			cache: false,
			timeout: 600000,
			success: function(data) {
				
				alert('success')
				window.location.href = "/worldCup";
			},
			error: function(e) {
				
				alert('fail');
			}
		});
	});
});   	