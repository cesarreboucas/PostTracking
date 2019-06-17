"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let dc = button.data('dc'); // Extract info from data-* attributes
	let modal = $(this)
	$.ajax({
		dataType: "json",
		url: "/dc/"+dc
	}).done(function(data) {
		//console.log(data);
		modal.find('.modal-title').text('Editing Distribution Center');
		modal.find('.modal-body').text(data.name)
	});
  })

