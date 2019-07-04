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
		table.appendChild(tr);
	});
	
	return table;
}