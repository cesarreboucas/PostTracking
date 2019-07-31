"use strict";

let method = 'post';

$('#modalForm').on('show.bs.modal', function (event) {
	const button = $(event.relatedTarget); // Button that triggered the modal
	const vehicle = button.data('vehicle'); // Extract info from data-* attributes
	method = button.data('method');
	const modal = $(this);
	if(vehicle!=0) {
		$.ajax({
			dataType: "json",
			url: "/vehicles/"+vehicle
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtDescription").value = data.description;
			document.getElementById("txtMaxVolume").value = data.maxVolume;
			document.getElementById("txtMaxWeight").value = data.maxWeight;
			document.getElementById("selectAvailable").value = data.available;
			console.log(data);
			modal.find("#modalTitle").text('Editing Vehicle');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtDescription").value = "";
		document.getElementById("txtMaxVolume").value = 0;
		document.getElementById("txtMaxWeight").value = 0;
		document.getElementById("selectAvailable").value = "";
		modal.find("#modalTitle").text('Adding Vehicle');
	}
});

$("#SaveVehicle").click(function(e) {
	console.log('[METHOD]', method);
	console.log('[VEHICLE_ID]', document.getElementById("txtId").value);
	const vehicle = {
		id: parseInt(document.getElementById("txtId").value),
		description: document.getElementById("txtDescription").value,
		maxVolume: document.getElementById("txtMaxVolume").value,
		maxWeight: document.getElementById("txtMaxWeight").value,
		available: document.getElementById("selectAvailable").value
	}

	$.ajax({
        type: method,
        contentType: "application/json; charset=utf-8",
        url: "/vehicles",
        traditional: true,
        data: JSON.stringify(vehicle)
    })
    .done(function(data) {
        setErrorMessage(data, 'success');
    })
    .fail(function( jqXHR, textStatus, errorThrown ) {
        setErrorMessage(jqXHR.responseText, 'danger');
    });
});

function setErrorMessage(errorMessage, level = 'warn', messageId = 'ErrorMessage') {
    let errorMessageDiv = document.getElementById(messageId);
    if(errorMessage === '') {
        errorMessageDiv.hidden = true;
        return;
    } else if(errorMessageDiv.hidden){
        errorMessageDiv.hidden = false;
    }

    switch(level) {
        case 'warn':
            errorMessageDiv.setAttribute('class', 'alert alert-warning');
            errorMessageDiv.innerHTML = errorMessage;
            break;
        case 'danger':
            errorMessageDiv.setAttribute('class', 'alert alert-danger');
            errorMessageDiv.innerHTML = errorMessage;
            break;
        case 'success':
            errorMessageDiv.setAttribute('class', 'alert alert-success');
            errorMessageDiv.innerHTML = errorMessage;
            break;
    }
}

