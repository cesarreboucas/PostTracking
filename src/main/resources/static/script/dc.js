"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let dc = button.data('dc'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#DCForm").append(inputMethod);
	let modal = $(this);
	if(dc!=0) {
		$.ajax({
			dataType: "json",
			url: "/dcs/"+dc
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtName").value = data.name;
			document.getElementById("txtAddress").value = data.address;
			document.getElementById("txtCity").value = data.city;
			document.getElementById("txtProvince").value = data.province;
			document.getElementById("txtZipCode").value = data.zipCode;
			modal.find("#modalTitle").text('Editing distribution center');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtName").value = "";
		document.getElementById("txtAddress").value = "";
		document.getElementById("txtCity").value = "";
		document.getElementById("txtProvince").value = "";
		document.getElementById("txtZipCode").value = "";
		modal.find("#modalTitle").text('Adding distribution center');
	}
  })

