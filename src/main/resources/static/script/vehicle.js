"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let vehicle = button.data('vehicle'); // Extract info from data-* attributes
	let modal = $(this);
	if(vehicle!=0) {
		$.ajax({
			dataType: "json",
			url: "/vehicles/"+vehicle
		}).done(function(data) {
			//console.log(vehicle);
			//console.log(data);
			$("#divDelete").css("display:none;");
			$("#chkDelete").prop("checked", false);
			$("#VehicleForm").attr("action", "/vehicles/"+data.id);
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtDescription").value = data.description;
			document.getElementById("txtMaxVolume").value = data.maxVolume;
			document.getElementById("txtMaxWeight").value = data.maxWeight;
			modal.find("#modalTitle").text('Editing Vehicle');
		});
	} else {
		//console.log(vehicle);
		$("#VehicleForm").attr("action", "/vehicles/0");
		$("#divDelete").css("display:none;");
		document.getElementById("txtId").value = 0;
		document.getElementById("txtDescription").value = "";
		document.getElementById("txtMaxVolume").value = 0;
		document.getElementById("txtMaxWeight").value = 0;
		modal.find("#modalTitle").text('Adding Vehicle');
	}
	
  })

