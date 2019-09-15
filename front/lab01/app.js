window.disciplinas;

let $disciplinas = document.querySelector('div');
let $add = document.querySelector("#add");
let $del = document.querySelector("#remove");

let $nome = document.querySelector("#nome_in");
let $nota = document.querySelector("#nota_in");
let $id = document.querySelector("#id");


let URL = 'https://lab01-projsw-ufcg.herokuapp.com/api/disciplinas';

$add.addEventListener('click', save);
$del.addEventListener('click', delete_);


function handler(dado) {
    console.log("handler dos dados");
    $disciplinas.innerHTML = "";
    window.disciplinas = dado;

    window.disciplinas.forEach(element => {
        let p = document.createElement('p');
        $disciplinas.appendChild(p);
        p.innerText = element.id + ') ' + element.nome + ': ' + element.nota;
    })
}

function fetch_disciplinas() {
    fetch(URL)
    .then(response => response.json())
    .then(dados => {
        handler(dados);
    });
}

function save() {
    let nome = document.querySelector("#nome_in").value;
    let nota = document.querySelector("#nota_in").value;

    fetch(URL, {
        'method': 'POST',
        'body': `{"nome": "${nome}", "nota": ${nota}}`,
        'headers': {'Content-Type': 'application/json'}
    })
    .then(retorno => retorno.json())
    .then(dado => {
        console.log(dado);
        window.disciplinas.push(dado);
        handler(window.disciplinas);
    });
}
window.save = save;


function delete_() {
    let id_ = document.querySelector("#id").value;

    fetch(URL + '/' + id_, {
        'method': 'DELETE'
    })
    .then(retorno => retorno.json())
    .then(dado => {
        console.log("removendo " + dado);
        console.log("handler dos dados");
        
        let arr = [];
    
        let i = 0;
        window.disciplinas.forEach(element => {
            if (element.id != id_) {
                arr[i] = element;
                i++;
            }
        })

        handler(arr);
    });
}

fetch_disciplinas();