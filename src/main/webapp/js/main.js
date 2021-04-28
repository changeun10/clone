function update(id) {
	var XHR = new XMLHttpRequest();
	var box = document.getElementById(id);
	var button = document.getElementById("b" + id);
	XHR.addEventListener("load", function() {
		if (XHR.status == 200) {

			if (XHR.responseText == "success") {

				var doing = document.querySelector("#DOING");
				var done = document.querySelector("#DONE");
				switch (box.parentNode.id) {
					case "TODO":
						box.remove();
						doing.appendChild(box);
						break;

					case "DOING":
						box.remove();
						done.appendChild(box)
						box.removeChild(button);
						break;
				}
			} else {
				alert("error!! Please try again!")
			}
		} else {
			alert("error!! Please try again!")
		}
	});
	var type;
	switch (box.parentNode.id) {
		case "TODO":
			type = "DOING";
			break;
		case "DOING":
			type = "DONE";
			break;
	}
	XHR.open("PUT", "changeservlet?id=" + id + "&type=" + type);
	XHR.send();
}