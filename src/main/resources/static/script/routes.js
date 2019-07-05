// GLOBAL VARIABLES
const routeTableHeaders = ['Origin', 'Destination', 'Start', 'Arrival'];
let vehicles = [];
let distributionCenters = [];
let tmpDistributionCenters = [];
let routes = [];
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
    tmpDistributionCenters = [...distributionCenters];
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
    routes.push({
        vehicleId: selectedVehicle.id,
        originName: '',
        originId: -1,
        destinationName: '',
        destinationId: -1,
        dateOrigin: 0,
        dateDestination: 0
    });
}

function createRow() {
    let routeTable = document.getElementById('RouteTable');

    tr = document.createElement('tr');
    routeTable.appendChild(tr);

    let td = document.createElement('td');
    let originSelect = createSelect('OriginSelect');
    td.appendChild(originSelect);
    tr.appendChild(td);

    td = document.createElement('td');
    let destinationSelect = createSelect('DestinationSelect');
    td.appendChild(destinationSelect);
    tr.appendChild(td);

    const idIndex = routes.length;

    td = document.createElement('td');
    let originDate = document.createElement('input');
    originDate.setAttribute('type', 'datetime-local');
    originDate.setAttribute('id', `OriginDate${idIndex}`);
    td.appendChild(originDate);
    tr.appendChild(td);

    td = document.createElement('td');
    let destinationDate = document.createElement('input');
    destinationDate.setAttribute('type', 'datetime-local');
    destinationDate.setAttribute('id', `DestinationDate${idIndex}`);
    td.appendChild(destinationDate);
    tr.appendChild(td);

    td = document.createElement('td');
    let buttonPlus = document.createElement('a');
    buttonPlus.setAttribute('class', 'btn btn-default btn-sm');
    buttonPlus.textContent = '+';
    buttonPlus.dataset['routeId'] = idIndex;
    buttonPlus.addEventListener('click', onAddTableRow)
    td.appendChild(buttonPlus);
    tr.appendChild(td);

    td = document.createElement('td');
    let buttonRemove = document.createElement('a');
    buttonRemove.setAttribute('class', 'btn btn-default btn-sm');
    buttonRemove.textContent = '-';
    buttonRemove.dataset['routeId'] = idIndex;
    buttonRemove.addEventListener('click', onRemoveRableRow);
    td.appendChild(buttonRemove);
    tr.appendChild(td);
}

function onAddTableRow(event) {
    const element = event.srcElement;
    const idIndex = element.dataset['routeId'];

    const selectOrigin = document.getElementById(`OriginSelect${idIndex}`);
    let selectOriginValue;
    if(selectOrigin.tagName === 'SELECT') {
        selectOriginValue = parseInt(selectOrigin.options[selectOrigin.selectedIndex].value);
    } else {
        selectOriginValue = parseInt(selectOrigin.dataset['dcId']);
    }
    const selectOriginText = selectOrigin.options[selectOrigin.selectedIndex].text;
    console.log('[SELECT_ORIGIN_VALUE]', selectOriginValue);

    const selectDestination = document.getElementById(`DestinationSelect${idIndex}`);
    let selectDestinationValue;
    if(selectDestination.tagName === 'SELECT') {
        selectDestinationValue = parseInt(selectDestination.options[selectDestination.selectedIndex].value);
    } else {
        selectDestinationValue = parseInt(selectDestination.dataset['dcId']);
    }

    const selectDestinationText = selectDestination.options[selectDestination.selectedIndex].text;
    
    const dateOrigin = document.getElementById(`OriginDate${idIndex}`);
    const dateOriginValue = dateOrigin.value;
    let dateOriginDate = Date.parse(dateOriginValue) / 1000;
    console.log('[DATE_ORIGIN_DATE]', dateOriginDate);

    const dateDestination = document.getElementById(`DestinationDate${idIndex}`);
    const dateDestinationValue = dateDestination.value;
    let dateDestinationDate = Date.parse(dateDestinationValue) / 1000;


    if(selectOriginValue === selectDestinationValue) {
        alert('Destination should be different than origin!');
        return;
    }
    if(!dateOriginValue || !dateDestinationValue) {
        alert('Please input valid dates');
        return;
    }
    if(dateOriginDate >= dateDestinationDate) {
        alert('Origin date should be smaller than arrival date');
        return;
    }
    if(routes.length > 1) {
        const index = routes.length - 1;
        if(dateOriginDate <= routes[index - 1].dateDestination) {
            alert('Origin date should be bigger than last arrival');
            return;
        }
    }

    console.log('[VALIDATION_PASSED!]');

    let route = routes[routes.length - 1];
    route.vehicleId = selectedVehicle.id;
    route.originName = selectOriginText;
    route.originId = selectOriginValue;
    route.destinationName = selectDestinationText;
    route.destinationId = selectDestinationValue;
    route.dateOrigin = dateOriginDate;
    route.dateDestination = dateDestinationDate;

    const indexToRemoveOrigin = tmpDistributionCenters.findIndex(distributionCenter => distributionCenter.id === selectDestinationValue);
    const indextoRemoveDestination = tmpDistributionCenters.findIndex(distributionCenter => distributionCenter.id === selectOriginValue);
    if(indexToRemoveOrigin >= 0) tmpDistributionCenters.splice(indexToRemoveOrigin, 1);
    if(indextoRemoveDestination >= 0) tmpDistributionCenters.splice(indextoRemoveDestination, 1);
    console.log('[TMP_DISTRIBUTION]', tmpDistributionCenters);

    createRow();
    routes.push({
        vehicleId: selectedVehicle.id,
        originName: '',
        originId: -1,
        destinationName: '',
        destinationId: -1,
        dateOrigin: 0,
        dateDestination: 0
    });
}

function onRemoveRableRow(event) {
    const element = event.srcElement;
    const idIndex = element.dataset['routeId'];

    if(routes.length < 2) {
        alert('The route should have at least one node');
        return;
    }

    const selectOrigin = document.getElementById(`OriginSelect${idIndex}`);
    let selectOriginValue;
    if(selectOrigin.tagName === 'SELECT') {
        selectOriginValue = parseInt(selectOrigin.options[selectOrigin.selectedIndex].value);
    } else {
        selectOriginValue = parseInt(selectOrigin.dataset['dcId']);
    }
    const originIndex = distributionCenters.findIndex(distributionCenter => distributionCenter.id === selectOriginValue);
    tmpDistributionCenters.push(distributionCenters[originIndex]);

    const selectDestination = document.getElementById(`DestinationSelect${idIndex}`);
    let selectDestinationValue;
    if(selectDestination.tagName === 'SELECT') {
        selectDestinationValue = parseInt(selectDestination.options[selectDestination.selectedIndex].value);
    } else {
        selectDestinationValue = parseInt(selectDestination.dataset['dcId']);
    }
    const destinationIndex = distributionCenters.findIndex(distributionCenter => distributionCenter.id === selectDestinationValue);
    tmpDistributionCenters.push(distributionCenters[destinationIndex]);

    const td = element.parentNode;
    const tr = td.parentNode;
    const table = tr.parentNode;
    table.removeChild(tr);

    routes.pop();
    console.log('[ROUTES]', routes);
}

function createSelect(type) {
    let element = null;
    const idIndex = routes.length;
    console.log('[ROUTES]', routes);
    if(routes.length > 1 && type === 'OriginSelect') {
        const route = routes[routes.length - 1];
        element = document.createElement('input');
        element.type = 'text';
        element.value = route.destinationName;
        element.dataset['dcId'] = route.originId;
        element.readOnly = true;
        element.id = `${type}${idIndex}`;
        element.setAttribute('class', 'form-group');
    } else {
        element = document.createElement('select');
        element.setAttribute('id', `${type}${idIndex}`);
        element.setAttribute('class', 'form-group');
        tmpDistributionCenters.forEach(distributionCenter => {
            let option = document.createElement('option');
            option.text = distributionCenter.name;
            option.value = distributionCenter.id;
            element.appendChild(option);
        });
    }
    return element;
}