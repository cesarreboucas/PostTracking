function Check(btn) {
    btn.disabled = true;
    $.ajax({
        method: "GET",
        url: "/packages/updateposition/"+btn.dataset.next+"/"+btn.dataset.id
    }).done(function(data) {
        console.log("Mudou "+data);
    });
    console.log(btn.dataset.id);
}