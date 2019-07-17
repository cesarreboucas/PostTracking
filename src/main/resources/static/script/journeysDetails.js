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
    }).done(function(data) {
        console.log(data);
    });
}