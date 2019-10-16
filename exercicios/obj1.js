function pessoa(nome) {
	return {
		nome: nome,
		fale: () => `oi meu nome é ${nome}`
	};
}

let p1 = pessoa("eu");
let p2 = pessoa("rafa");
let p = [p1, p2];

p.forEach(a => {
	console.log(a.fale());
});
