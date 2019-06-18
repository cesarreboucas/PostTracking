"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	const button = $(event.relatedTarget); // Button that triggered the modal
	const vehicle = button.data('vehicle'); // Extract info from data-* attributes
	const method = button.data('method');
	console.log('[METHOD]', method);
	const inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#VehicleForm").append(inputMethod);
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
			modal.find("#modalTitle").text('Editing Vehicle');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtDescription").value = "";
		document.getElementById("txtMaxVolume").value = 0;
		document.getElementById("txtMaxWeight").value = 0;
		modal.find("#modalTitle").text('Adding Vehicle');
	}
	
  })

