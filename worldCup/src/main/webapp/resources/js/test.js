function onClick(event) {
	event.remove();
	var files = document.querySelector("#image").files;
	delete files["0"]
	
}

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
			input.setAttribute("type", "text");
			input.setAttribute("name", "name");
			input.setAttribute("size", "10");

			var btn = document.createElement("button");
			btn.setAttribute("onclick", "onClick(this.parentNode)")
			btn.setAttribute("type", "button")
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