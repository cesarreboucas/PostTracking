"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let customer = button.data('customer'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#CustomerForm").append(inputMethod);
	let modal = $(this);
	if(customer!=0) {
		$.ajax({
			dataType: "json",
			url: "/customers/"+customer
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtFirstName").value = data.firstName;
			document.getElementById("txtLastName").value = data.lastName;
			document.getElementById("txtPhoneNumber").value = data.phoneNumber;
			document.getElementById("txtEmailAddress").value = data.emailAddress;
			document.getElementById("txtAddress").value = data.address;
			document.getElementById("txtCity").value = data.city;
			document.getElementById("txtProvince").value = data.province;
			document.getElementById("txtZipCode").value = data.zipCode;
			modal.find("#modalTitle").text('Editing customer');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtFirstName").value = "";
		document.getElementById("txtLastName").value = "";
		document.getElementById("txtPhoneNumber").value = "";
		document.getElementById("txtEmailAddress").value = "";
		document.getElementById("txtAddress").value = "";
		document.getElementById("txtCity").value = "";
		document.getElementById("txtProvince").value = "";
		document.getElementById("txtZipCode").value = "";
		modal.find("#modalTitle").text('Adding customer');
	}
  })

