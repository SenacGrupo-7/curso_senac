var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

var request = new XMLHttpRequest();

request.open('GET', 'https://servicodados.ibge.gov.br/api/v2/cnae/classes/01113', true);

request.onload = function () {
    var data = JSON.parse(this.responseText)

    if (request.status >= 200 && request.status < 400) {

        console.log(data)

    } else {
        console.log('erro');
    }
}

request.send()













