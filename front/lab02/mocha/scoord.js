// para executar o mocha faz:
// ./node_modules/mocha/bin/mocha

exports.disciplina = function disciplina(id, nome, creditos, pre_requisitos) {
    let d = Object.create(Object.prototype);

    d.nome = nome;
    d.creditos = creditos;
    d.pre_requisitos = pre_requisitos;

    d.id = function () {
        return id;
    }

    d.set_nome = function (novo) {
        d.nome = novo; 
    };

    d.get_nome = function () {
        return d.nome;
    };
   
    return d;
}

exports.turma = function turma(disciplina, periodo)  {
    turma.periodo = periodo;
    turma.prof = null;
    turma.alunos = [];
    turma.status = "planejada";
    
    turma.disciplina = disciplina;

    turma.defineProf = function (prof) {
        turma.professor = prof;
    };

    turma.set_status = function (novo) {
        if (novo === "planejada" || novo ===  "ativa" || novo ===  "concluída") {
            turma.status = novo;
        }
    };

    turma.matricula = function (estudante) {
        if (turma.status === "planejada" || turma.status ===  "ativa") {
            if (!turma.alunos.find(estudante)) {
                turma.alunos.push(estudante);
            }
        }
    }

    turma.desmatricula = !""!""


}
