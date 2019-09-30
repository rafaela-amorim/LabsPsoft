let proto_pessoa = {
	fala: function (nome) { return "oi, eu sou " + nome; }
}

function create_pessoa(nome) {
	let pessoa = Object.create(proto_pessoa);
	pessoa.nome = nome;
	
	pessoa.fale = function () { return pessoa.fala(pessoa.nome); };

	return pessoa;
}

p1 = create_pessoa("rafa");
p2 = create_pessoa();
p3 = create_pessoa();

console.log(p1.fale());
