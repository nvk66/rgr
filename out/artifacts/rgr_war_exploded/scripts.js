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