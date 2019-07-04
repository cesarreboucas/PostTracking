"use strict";

let form = document.getElementById("PackageFilterForm");
window.onload = function () {
    //let  table = $('#packTable').DataTable();
    form.onsubmit = (function (e) {
        e.preventDefault();
        
        $.ajax({
            method: "POST",
            dataType: "json",
            data: {
                "origin_id" : document.getElementById("selOriginSearch").value,
                "destination_id" : document.getElementById("selDestinationSearch").value,
                "customer_id" : document.getElementById("selCustomerSearch").value,
            },
            url: "/packages/search/"
        }).done(function(packages) {
            //console.log(packages);
            let dataset = Array();
            let arrayLine;
            packages.forEach(pack => {

                arrayLine = [pack.id, pack.customer.fullName, pack.origin.name, pack.destination.name];
                pack.journeys.forEach(journey => {
                    if(pack.position.id==journey.origin.id) {
                        arrayLine.push("<a href=\"/journeys/"+journey.id+"\">"+pack.position.name+" => "+journey.destination.name+"</a>",
                            formatDate(new Date(journey.start)));
                    }
                });
                dataset.push(arrayLine);
            });

            if ( $.fn.dataTable.isDataTable( '#packTable' ) ) {
                $('#packTable').DataTable().destroy();
            }

            $('#packTable').DataTable({
                data: dataset,
                searching: false,
                "columnDefs": [ {
                    "targets": 0,
                    "data": 0,
                    render : function(data, type, row) {
                        return '<button data-package="'+data+'" type="button" class="btn-secondary btn-sm btn-block btn-primary" \
                        data-toggle="modal" data-target="#modalPackageEdit">'+data+'</button>'
                        /*'<button class="btn btn-sm btn-block" \
                            onclick="console.log(\''+data+'\')">'+data+'</button>'*/

                    }
                }],
                columns: [
                    { title: "#" },
                    { title: "Customer" },
                    { title: "Origin" },
                    { title: "Destination" },
                    { title: "Journey" },
                    { title: "Departure" }
                ]
            });
        });
    });
}

function formatDate(date) {
	let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	return date.getDate()+"-"+months[date.getMonth()]+"-"+date.getFullYear()+" "+
			date.getHours().toString().padStart(2,"0")+":"
			+date.getMinutes().toString().padStart(2,"0")+" ("+days[date.getDay()]+")";
}