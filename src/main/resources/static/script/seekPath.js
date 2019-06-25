"use strict";

document.getElementById("selDestination").value = 5;

window.onload = function() {
    document.getElementById("btnSeekPath").addEventListener('click', function() {
    	let origin = document.getElementById("selOrigin").value;
			let destination = document.getElementById("selDestination").value;
			if(origin==destination) {
				$('#paths').html("<strong>Origin can't be the same as destination</strong>");
				return false;
			}
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
	// Make Table and header
	let table = document.createElement("table");
	table.className = "table";
	let tr = document.createElement("tr");
	let th = document.createElement("th");
	th.textContent = "Origin";
	tr.appendChild(th);
	th = document.createElement("th");
	th.textContent = "Destination";
	tr.appendChild(th);
		th = document.createElement("th");
	th.textContent = "Date";
	tr.appendChild(th);
	table.appendChild(tr);
	
	let journeys = Array();

	p.path.forEach(j => {
		// Adding the journey ID
		journeys.push(j.id);
		// making the lines of the table
		let date = new Date(j.start);
		tr = document.createElement("tr");
		let td = document.createElement("td");
		td.textContent = j.origin.name;
		tr.appendChild(td);
		td = document.createElement("td");
		td.textContent = j.destination.name;
		tr.appendChild(td);
		td = document.createElement("td");
		td.textContent = formatDate(date)
		tr.appendChild(td);
		table.appendChild(tr);
	});
		console.log(journeys);

		tr = document.createElement("tr");
		th = document.createElement("th");
		th.setAttribute("colspan",3);
		th.style.textAlign = "right";

		let button = document.createElement("button");
		button.className = "btn btn-sm btn-primary";
		button.textContent = "Choose"
		button.addEventListener("click", function() {sendPackage(journeys)});
		th.appendChild(button);

		//th.innerHTML = "<button type=\"button\" class=\"btn btn-sm btn-primary\" onClick=\"sendPackage("+journeys+")\">Choose</button>";
		tr.appendChild(th);
		table.appendChild(tr);

	
	// making the Card
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

function formatDate(date) {
	let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	return date.getDate()+"-"+months[date.getMonth()]+"-"+date.getFullYear()+" "+
			date.getHours().toString().padStart(2,"0")+":"
			+date.getMinutes().toString().padStart(2,"0")+" ("+days[date.getDay()]+")";
}

function sendPackage(journeys) {
	document.getElementById("txtJourneys").value = journeys;
	document.getElementById("PackageForm").submit();
}