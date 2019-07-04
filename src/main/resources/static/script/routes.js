// GLOBAL VARIABLES
const routeTableHeaders = ['Origin', 'Destination', 'Start', 'Arrival', 'Remove'];
let vehicles = [];
let distributionCenters = [];
let tmpDistributionCenters = [];
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
    clearFormContainer();
    Promise.all([getVehicles, getDistributionCenters])
    .then((data) => {
        vehicles = data[0];
        distributionCenters = data[1];
        console.log('[VEHICLES]', vehicles);
        console.log('[DISTRIBUTION_CENTER]', distributionCenters);
        createDropDown();
    })
    .catch(onFetchFail);
}

function createDropDown() {
    let formContainer = document.getElementById('FormContainer');

    let vehiclesDropDown = document.createElement('div');
    vehiclesDropDown.setAttribute('class', 'btn-group');
    formContainer.appendChild(vehiclesDropDown);

    let vehiclesDropDownTrigger = document.createElement('button');
    vehiclesDropDownTrigger.setAttribute('type', 'button');
    vehiclesDropDownTrigger.setAttribute('class', 'btn btn-primary dropdown-toggle');
    vehiclesDropDownTrigger.setAttribute('data-toggle', 'dropdown');
    vehiclesDropDownTrigger.setAttribute('aria-haspopup', 'true');
    vehiclesDropDownTrigger.setAttribute('aria-expanded', 'false');
    vehiclesDropDownTrigger.textContent = 'Selecione o veiculo';
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
}

function onFetchFail(error) {
    console.log('[ERROR]', error);
}

function onDropDownMenuClick(event) {
    const element = event.srcElement;
    const vehicleId = parseInt(element.getAttribute('data-vehicleId'));
    vehicles.forEach(vehicle => {
        if(vehicle.id === vehicleId) {
            selectedVehicle = vehicle;
            return;
        }
    });
    console.log('[SELECTED_VEHICLE]', selectedVehicle);
    clearFormContainer()
    createCard();
}

function createCard() {
    let formContainer = document.getElementById('FormContainer');

    let card = document.createElement('div');
    card.setAttribute('class', 'card');
    formContainer.appendChild(card);

    let cardHeader = document.createElement('div');
    cardHeader.setAttribute('class', 'card-header');
    cardHeader.textContent = selectedVehicle.description;
    card.appendChild(cardHeader);

    let cardBody = document.createElement('div');
    cardBody.setAttribute('class', 'card-body');
    card.appendChild(cardBody);

    let routeTable = document.createElement('table');
    routeTable.setAttribute('class', 'table');
    cardBody.appendChild(routeTable);

    let tr = document.createElement('tr');
    routeTable.appendChild(tr);

    routeTableHeaders.forEach(routeTableHeader => {
        let th = document.createElement('th');
        th.textContent = routeTableHeader;
        tr.appendChild(th);
    });

    tr = document.createElement('tr');
    routeTable.appendChild(tr);

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

    $('#modalForm').modal('handleUpdate')
}

function createSelect() {
    let select = document.createElement('select');
    select.setAttribute('class', 'form-group');
    distributionCenters.forEach(distributionCenter => {
        let option = document.createElement('option');
        option.textContent = distributionCenter.name;
        select.appendChild(option);
    });
    return select;
}