$('#modalPackageEdit').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget); // Button that triggered the modal
    const package = button.data('package'); // Extract info from data-* attributes.
    $.ajax({
        dataType: "json",
        url: "/packages/"+package
    }).done(function(data) {
        document.getElementById("txtId").value = data.id;
        document.getElementById("selcustomer").value = data.customer.id;
        document.getElementById("txtWeight").value = data.weight;
        document.getElementById("txtVolume").value = data.volume;
        document.getElementById("txtRecipient").value = data.recipient;
        document.getElementById("txtAddress").value = data.address;
        document.getElementById("txtCity").value = data.city;
        document.getElementById("txtProvince").value = data.province;
        document.getElementById("txtZipCode").value = data.zipCode;
        document.getElementById("selOrigin").value = data.origin.id;
		document.getElementById("selDestination").value = data.destination.id;
		
		let option = document.createElement("option");
		option.value = data.position.id;
		option.text = data.position.name;
		document.getElementById("selPosition").appendChild(option);
        document.getElementById("selPosition").value = data.position.id;
        // Cleaning the table
        let journeyDiv = document.getElementById("journeysDiv")
        while (journeyDiv.firstChild) {
            journeyDiv.removeChild(journeyDiv.firstChild);
        }
        journeyDiv.appendChild(makeTable(data));
    });
});

function makeTable(p) {
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

	
	console.log(p.journeys);
	let position = p.origin.id;
	while(p.journeys.length>0) {
		for(let y=0; y < p.journeys.length; ++y) {
			//console.log("position: "+position+" origin: "+p.journeys[y].origin.id)
			if(position==p.journeys[y].origin.id) {
				let date = new Date(p.journeys[y].start);
				tr = document.createElement("tr");
				let td = document.createElement("td");
				td.textContent = p.journeys[y].origin.name;
				if(p.position.id==p.journeys[y].origin.id) {
					td.style.fontWeight = "bold";
					td.style.backgroundColor = "#ADD8E6";
				}
				tr.appendChild(td);
				td = document.createElement("td");
				td.textContent = p.journeys[y].destination.name;
				tr.appendChild(td);
				td = document.createElement("td");
				td.textContent = formatDate(date)
				tr.appendChild(td);
				td = document.createElement("td");
				td.textContent = p.journeys[y].vehicle.description;
				tr.appendChild(td);
				table.appendChild(tr);
				position=p.journeys[y].destination.id;
				p.journeys.splice(y,1);
				--y;
			}
		}
	}
	
	return table;
}

function formatDate(date) {
	let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	return date.getDate()+"-"+months[date.getMonth()]+"-"+date.getFullYear()+" "+
			date.getHours().toString().padStart(2,"0")+":"
			+date.getMinutes().toString().padStart(2,"0")+" ("+days[date.getDay()]+")";
}