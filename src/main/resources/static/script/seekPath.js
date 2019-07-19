"use strict";

window.onload = function() {
    document.getElementById("btnSeekPath").addEventListener('click', function() {
			let origin = document.getElementById("selOrigin").value;
			let destination = document.getElementById("selDestination").value;
			let volume = document.getElementById("txtVolume").value;
			let weight = document.getElementById("txtWeight").value;
			this.disabled = true;
			this.innerHTML = "Checking...";
			if(origin==destination) {
				$('#paths').html("<strong>Origin can't be the same as destination</strong>");
				return false;
			}
			if(isNaN(parseInt(origin,10)) && isNaN(parseInt(destination,10))) {
				$('#paths').html("<strong>Sorry, I could't understand your Distrtribution Centers</strong>");
				return false;
			}
			if(isNaN(parseFloat(volume)) && isFloat(parseFloat(weight))) {
				$('#paths').html("<strong>Sorry, I need numbers on Weight and Volume</strong>");
				return false;
			}
			$.ajax({
				dataType: "json",
				url: "/packages/seekpath/"+origin+"/"+destination+"/"+weight+"/"+volume
			}).done(function(data) {
				// Walking Paths
				$('#paths').html("");
				data.forEach(path => {
					document.getElementById("paths").appendChild(makeCard(path));
					document.getElementById("paths").appendChild(document.createElement("br"));				
				});
			});
			this.disabled = false;
			this.innerHTML = "Seek Path";	
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
	th = document.createElement("th");
	th.textContent = "Vehicle";
	tr.appendChild(th);
	table.appendChild(tr);
	
	let journeys = Array();

	p.journeys.forEach(j => {
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
		td = document.createElement("td");
		td.textContent = j.vehicle.description;
		tr.appendChild(td);
		table.appendChild(tr);
	});

		tr = document.createElement("tr");
		th = document.createElement("th");
		th.setAttribute("colspan",4);
		th.style.textAlign = "right";

		let button = document.createElement("button");
		button.className = "btn btn-sm btn-primary";
		button.textContent = "Choose"
		button.name = "BtnChoose"
		button.addEventListener("click", function() {sendPackage(journeys)});
		th.appendChild(button);

		tr.appendChild(th);
		table.appendChild(tr);

	
	// making the Card
	let mainDiv = document.createElement("div");
	mainDiv.className = "card";
	let headerDiv = document.createElement("div");
	headerDiv.className = "card-header";
	headerDiv.textContent = "Journeys";
	let bodyDiv = document.createElement("div");
	bodyDiv.className = "card-body";
	bodyDiv.appendChild(table);
	mainDiv.appendChild(headerDiv);
	mainDiv.appendChild(bodyDiv);
	
	return mainDiv;
}

document.getElementById("txtWeight").addEventListener("change", lockChooseBtn);
document.getElementById("txtVolume").addEventListener("change", lockChooseBtn);

function lockChooseBtn() {
	document.getElementsByName("BtnChoose").forEach(btn => {
		btn.disabled = true;
	});
}



function sendPackage(journeys) {
	document.getElementById("txtJourneys").value = journeys;
	document.getElementById("PackageForm").submit();
}