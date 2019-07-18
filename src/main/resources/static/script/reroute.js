"use strct";
function setReroute(button) {
    let table = $(button).parents("table")[0];
    let trs = table.children[0].children;
    let package = {"id": trs[0].dataset.id, "journeys": []};
    
    // Last line contains nothing
    for(let i=1 ; i < (trs.length-1); ++i) {
        package.journeys.push(Number.parseInt(trs[i].dataset.id,10));    
    }
    document.getElementById("txtId").value = package.id;
    document.getElementById("txtJourneys").value = package.journeys;
	document.getElementById("ReRouteForm").submit();


}