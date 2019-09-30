function create_pessoa(nome) {
    let pessoa = {};
    pessoa.nome = nome;
    pessoa.fale = function () { return "oi, eu sou " + pessoa.nome };
    return pessoa;
}
p = create_pessoa('Fulano');
console.log(p.fale());
