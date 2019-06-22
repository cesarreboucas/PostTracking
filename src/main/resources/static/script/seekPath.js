"use strict";


window.onload = function() {
    document.getElementById("btnSeekPath").addEventListener('click', function() {
    	let origin = document.getElementById("selOrigin").value;
    	let destination = document.getElementById("selDestination").value;
		$.ajax({
			dataType: "json",
			url: "/packages/seekpath/"+origin+"/"+destination
		}).done(function(data) {
			// Walking Paths
			$('#paths').html("");
			data.forEach(path => {
				makeCard(path);				
			});
		});
    });
}

function makeCard(p) {
	console.log(p);
	let table = document.createElement("table");
	table.className = "table";
	let tr = document.createElement("tr");
	let th = document.createElement("th");
	th.textContent = "Origin";
	tr.appendChild(th);
	console.log(tr);
	th = document.createElement("th");
	th.textContent = "Destination";
	tr.appendChild(th);
	console.log(tr);
	th = document.createElement("th");
	th.textContent = "Date";
	tr.appendChild(th);
	console.log(tr);
	table.appendChild(tr);
	console.log(table);

	p.path.forEach(j => {
		let date = new Date(j.start);
		tr = document.createElement("tr");
		let td = document.createElement("td");
		td.textContent = j.origin.name;
		tr.appendChild(td);
		td = document.createElement("td");
		td.textContent = j.destination.name;
		tr.appendChild(td);
		td = document.createElement("td");
		td.textContent = date;
		tr.appendChild(td);
		table.appendChild(tr);
	});
	 
	console.log(table);
	//return content;
	
	let mainDiv = document.createElement("div");
	mainDiv.className = "card";
	let headerDiv = document.createElement("div");
	headerDiv.className = "card-header";
	headerDiv.textContent = "Rota";
	let bodyDiv = document.createElement("div");
	bodyDiv.className = "card-body";
	bodyDiv.appendChild(table);
	mainDiv.appendChild(headerDiv);
	mainDiv.appendChild(bodyDiv);
	
	document.getElementById("paths").appendChild(mainDiv);
	document.getElementById("paths").appendChild(document.createElement("br"));
	
}
