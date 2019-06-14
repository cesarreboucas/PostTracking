"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let vehicle = button.data('vehicle'); // Extract info from data-* attributes
	let modal = $(this)
	$.ajax({
		dataType: "json",
		url: "/vehicle/"+vehicle
	}).done(function(data) {
		//console.log(data);
		modal.find('.modal-title').text('Editing Vehicle');
		modal.find('.modal-body').text(data.description)
	});
  })

