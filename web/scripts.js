function registerClient(name,lastName,number) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST','Controller');
    let json ='';
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            let response = JSON.parse(xhr.responseText);
            console.log(response);
            return response;
        }
    }
    json ={ 'name' : name ,'lastName' : lastName , 'number' : number, 'method' : 'registerClient' } ;
    xhr.send(JSON.stringify(json));
}

function registerDriver(name,lastName,carModel,carNumber,carColor) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST','Controller');
    let json ='';
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            let response = JSON.parse(xhr.responseText);
            console.log(response);
            return response;
        }
    }
    json ={ 'name' : name ,'lastName' : lastName , 'carNumber' : carNumber,'carColor': carColor,'carModel' : carModel,
            'method' : 'registerDriver'} ;
    xhr.send(JSON.stringify(json));
}

function addOrders(name,start,end) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST','Controller');
    let json ='';
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            let response = JSON.parse(xhr.responseText);
            console.log(response);
            return response;
        }
    }
    json ={ 'clientName' : name , 'method' : 'addOrder','startLocation':start,'endLocation':end } ;
    xhr.send(JSON.stringify(json));
}

function getOrders(name,list) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST','Controller');
    let json ='';
    xhr.onreadystatechange = function() { // (3)
        if (xhr.readyState != 4) return

        if (xhr.status != 200) {
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            let orders = JSON.parse(xhr.responseText);
            let li = list;
            while(li.firstChild) {
                li.removeChild(li.firstChild);
            }
            console.log(orders)
            orders.forEach(function (order) {
                li = li.appendChild(document.createElement('li'));
                li.innerHTML =' ' + order.carColor + ' ' +  order.carModel + ' ' + order.carNumber + '' + order.endLocation +
                    ' ' + order.startLocation +' '+ order.lastName + ' ' + order.name + ' ' + order.price;
            })
        }
    }
    json ={ 'name' : name , 'method' : 'getAllClientHistory' } ;
    xhr.send(JSON.stringify(json));
}
