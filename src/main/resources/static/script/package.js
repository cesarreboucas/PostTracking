"use strict";

let form = document.getElementById("PackageFilterForm");
window.onload = function () {
    form.onsubmit = (function (e) {
        e.preventDefault();
        
        $.ajax({
            method: "POST",
            dataType: "json",
            data: {
                "origin_id":"0",
                "destination_id":"0",
                "customer_id":"0",
            },
            url: "/packages/search/"
        }).done(function(packages) {
            console.log(packages);
            let dataset = Array();
            packages.forEach(pack => {
                dataset.push([pack.id, pack.customer.fullName, pack.origin.name, pack.destination.name, pack.position.name])
            });
            $('#packTable').DataTable({
                data: dataset,
                columns: [
                    { title: "#" },
                    { title: "Customer" },
                    { title: "Origin" },
                    { title: "Destination" },
                    { title: "Position" }
                ]
            });
        });
    });
}