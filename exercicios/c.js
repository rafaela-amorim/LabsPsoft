function create_turma(disciplina, v) {
	return {
		nome: disciplina,
		vag: v,
		als: [],
		matricule: function (aluno) {
			if (this.vag <= 0) return false;
			this.vag--;
			this.als.push(aluno);
			return true;
		},
		alunos: function () { return this.als; },
		vagas: function () { return this.vag; }
	};
}

d1 = create_turma('math',2);
console.log(d1.vagas());
