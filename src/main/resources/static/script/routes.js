// GLOBAL VARIABLES
const routeTableHeaders = ['Origin', 'Destination', 'Start', 'Arrival'];
let vehicles = [];
let distributionCenters = [];
let selectedVehicle = null;

const getVehicles = new Promise((resolve, reject) => {
    $.ajax({
        dataType: "json",
        url: "/api/vehicles"
    })
    .done(function(data) {
        resolve(data);
    })
    .fail(function( jqXHR, textStatus, errorThrown ) {
        reject(new Error(errorThrown))
    });
});

const getDistributionCenters = new Promise((resolve, reject) => {
    $.ajax({
        dataType: "json",
        url: "/api/dcs"
    })
    .done(function(data) {
        resolve(data);
    })
    .fail(function( jqXHR, textStatus, errorThrown ) {
        reject(new Error(errorThrown))
    });
});

$('#modalForm').on('show.bs.modal', createModal);

function clearFormContainer() {
    let formContainer = document.getElementById('FormContainer');
    while (formContainer.firstChild) {
        formContainer.removeChild(formContainer.firstChild);
    }
}

function createModal(event) {
    Promise.all([getVehicles, getDistributionCenters])
    .then((data) => {
        vehicles = data[0];
        distributionCenters = data[1];
        selectedVehicle = null;
        console.log('[VEHICLES]', vehicles);
        console.log('[DISTRIBUTION_CENTER]', distributionCenters);
        createCard();
    })
    .catch(onFetchFail);
}

function onFetchFail(error) {
    console.log('[ERROR]', error);
}

function createDropDown() {
    //let formContainer = document.getElementById('FormContainer');

    let vehiclesDropDown = document.createElement('div');
    vehiclesDropDown.setAttribute('class', 'btn-group');
    //formContainer.appendChild(vehiclesDropDown);

    let vehiclesDropDownTrigger = document.createElement('button');
    vehiclesDropDownTrigger.setAttribute('type', 'button');
    vehiclesDropDownTrigger.setAttribute('class', 'btn btn-primary dropdown-toggle');
    vehiclesDropDownTrigger.setAttribute('data-toggle', 'dropdown');
    vehiclesDropDownTrigger.setAttribute('aria-haspopup', 'true');
    vehiclesDropDownTrigger.setAttribute('aria-expanded', 'false');
    vehiclesDropDownTrigger.textContent = 'Select a vehicle';
    vehiclesDropDownTrigger.id = 'DropDownTrigger';
    vehiclesDropDown.appendChild(vehiclesDropDownTrigger);

    let vehiclesDropDownMenu = document.createElement('div');
    vehiclesDropDownMenu.setAttribute('class', 'dropdown-menu');
    vehiclesDropDown.appendChild(vehiclesDropDownMenu)

    vehicles.forEach(vehicle => {
        let vehiclesDropDownMenuItem = document.createElement('a');
        vehiclesDropDownMenuItem.setAttribute('class', 'dropdown-item');
        vehiclesDropDownMenuItem.setAttribute('data-vehicleId', vehicle.id.toString());
        vehiclesDropDownMenuItem.addEventListener('click', onDropDownMenuClick);
        vehiclesDropDownMenuItem.textContent = vehicle.description;
        vehiclesDropDownMenu.appendChild(vehiclesDropDownMenuItem);
    });

    return vehiclesDropDown;
}

function onDropDownMenuClick(event) {
    const dropDownTrigger = document.getElementById('DropDownTrigger');
    const element = event.srcElement;
    const vehicleId = parseInt(element.getAttribute('data-vehicleId'));
    vehicles.forEach(vehicle => {
        if(vehicle.id === vehicleId) {
            selectedVehicle = vehicle;
            return;
        }
    });
    dropDownTrigger.textContent = selectedVehicle.description;
}

function createCard() {
    let formContainer = document.getElementById('FormContainer');

    let card = document.createElement('div');
    card.setAttribute('class', 'card');
    formContainer.appendChild(card);

    let cardHeader = document.createElement('div');
    cardHeader.setAttribute('class', 'card-header');
    cardHeader.appendChild(createDropDown());
    card.appendChild(cardHeader);

    let cardBody = document.createElement('div');
    cardBody.setAttribute('class', 'card-body');
    card.appendChild(cardBody);

    let routeTable = document.createElement('table');
    routeTable.setAttribute('class', 'table');
    routeTable.setAttribute('id', 'RouteTable');
    cardBody.appendChild(routeTable);

    let tr = document.createElement('tr');
    routeTable.appendChild(tr);

    routeTableHeaders.forEach(routeTableHeader => {
        let th = document.createElement('th');
        th.textContent = routeTableHeader;
        tr.appendChild(th);
    });

    createRow();
}

function createRow() {
    tr = document.createElement('tr');

    let td = document.createElement('td');
    let originSelect = createSelect();
    td.appendChild(originSelect);
    tr.appendChild(td);

    td = document.createElement('td');
    let destinationSelect = createSelect();
    td.appendChild(destinationSelect);
    tr.appendChild(td);

    td = document.createElement('td');
    let originDate = document.createElement('input');
    originDate.setAttribute('type', 'datetime-local');
    td.appendChild(originDate);
    tr.appendChild(td);

    td = document.createElement('td');
    let destinationDate = document.createElement('input');
    destinationDate.setAttribute('type', 'datetime-local');
    td.appendChild(destinationDate);
    tr.appendChild(td);

    td = document.createElement('td');
    let buttonRemove = document.createElement('a');
    buttonRemove.setAttribute('class', 'btn btn-default btn-sm');
    buttonRemove.textContent = '-';
    buttonRemove.addEventListener('click', onRemoveRableRow);
    td.appendChild(buttonRemove);
    tr.appendChild(td);

    const routeTable = document.getElementById('RouteTable');
    routeTable.appendChild(tr);
}

function onAddTableRow(event) {
    const element = event.srcElement;
    const tr = $(element).closest('tr');
    createRow(tr);
}

function onRemoveRableRow(event) {
    const element = event.srcElement;
    const td = element.parentNode;
    const tr = td.parentNode;
    const table = tr.parentNode;
    table.removeChild(tr);
}

function createSelect() {
    let element = document.createElement('select');
    element.setAttribute('class', 'form-group');
    distributionCenters.forEach(distributionCenter => {
        let option = document.createElement('option');
        option.text = distributionCenter.name;
        option.value = distributionCenter.id;
        element.appendChild(option);
    });
    return element;
}

$('#CreateRow').click(function() {
    createRow();
});

$('#CreateRoute').click(function() {
    let routes = [];
    const trs = $('#RouteTable').children();
    if(selectedVehicle == null) {
        alert('Routes need a vehicle');
        return;
    }
    if(trs.length <= 2) {
        alert('You need at least two nodes to create a route');
        return;
    }

    for (let i = 1; i < trs.length; i++) {
        const tds = $(trs[i]).children();
        
        // SELECT ORIGIN
        const selectOrigin = $(tds[0]).find('select');
        const originValue = $(selectOrigin).find(':selected').val();

        // SELECTDESTINATION
        const selectDestination = $(tds[1]).find('select');
        const destinationValue = $(selectDestination).find(':selected').val();

        if(originValue === destinationValue) {
            alert(`Error for route ${i}: Origin and destination location shouldn't be the same`);
            return;
        }
        if(routes.length > 0) {
            console.log('[ROUTES]', routes);
            if(originValue !== routes[i - 2].destination) {
                alert(`Error for route ${i}: Origin for route ${i} should be equal the origin of route ${i-1}`);
                return;
            }
        }

        // INPUT DATETIME-LOCAL ORIGIN
        const dateOrigin = $(tds[2]).find('input');
        const originDate = $(dateOrigin).val();
        let originTimeStamp;
        if(!originDate) {
            alert(`Error for route ${i}: Date of origin should be set`);
            return;
        } else {
            originTimeStamp = Date.parse(originDate)/1000;
        }
        

        // INPUT DATETIME-LOCAL DESTINATION
        const dateDestination = $(tds[3]).find('input');
        destinationDate = $(dateDestination).val();
        let destinationTimeStamp;
        if(!destinationDate) {
            alert(`Error for route ${i}: Date of destination should be set`);
            return;
        } else {
            destinationTimeStamp = Date.parse(destinationDate)/1000;
        }

        if(destinationTimeStamp <= originTimeStamp) {
            alert(`Error for route ${i}: Date of arrival should be bigger than origin`);
        }
        if(routes.length > 0) {
            if(originTimeStamp <= routes[i-2].destinationDate) {
                alert(`Error for route ${i}: Date of origin for route ${i} should be bigger than arrival for route ${i-1}`);
            }
        }

        routes.push({
            vehicleId: selectedVehicle.id,
            origin: originValue,
            destination: destinationValue,
            originDate: originTimeStamp,
            destinationDate: destinationTimeStamp
        });
    }

    console.log('[ROUTES]', routes);
});