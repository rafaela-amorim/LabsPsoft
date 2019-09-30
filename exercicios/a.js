function create_turma(disciplina, v) {
	let turma = {};
	let als = [];
	let vaga = v;

	turma.matricule = function (aluno) {
		if (vaga > 0) {
			vaga--;
			als.push(aluno);
			return true;
		}
		return false;
	};

	turma.alunos = function () { return als; };

	turma.vagas = function () { return vaga; };

	return turma;
}

d1 = create_turma('logica', 2);
d1.matricule('rafa');
d1.matricule('gabys');
d1.matricule('alo');
console.log(d1.vagas());
console.log(d1.alunos());

d2 = create_turma('estatistica',3);
d2.matricule('eu');
console.log(d2.alunos());
