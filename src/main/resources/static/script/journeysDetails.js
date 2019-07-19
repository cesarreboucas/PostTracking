"use strict";

function Check(btn) {
    btn.disabled = true;
    $.ajax({
        method: "GET",
        url: "/packages/updateposition/"+btn.dataset.next+"/"+btn.dataset.id
    }).done(function(data) {
        console.log("Mudou "+data);
    });
}

function checkAll(btn) {
    btn.disabled = true;
    $.ajax({
        method: "GET",
        url: "/journeys/checkpackages/"+btn.dataset.j
    }).done(function(data, textStatus, XHR) {
        if(XHR.status==200) {
            document.getElementById("div_info").style.display = 'block';
            document.getElementById("div_info").innerHTML = "Packages checked successfully";
            $('td[name=tdPosition]').html(data);
            $('button[name=btnCheck]').attr("disabled", true);

        } else {
            document.getElementById("div_info").style.display = 'block';
            document.getElementById("div_info").innerHTML = "Sorry, something went wrong :/";
        }
    });
}