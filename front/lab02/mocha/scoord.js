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
    let turma = Object.create(Object.prototype);

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

    turma.get_status = () => turma.status;

    turma.matricula = function (estudante) {
        if (turma.status === "planejada" || turma.status ===  "ativa") {
            if (!turma.alunos.includes(estudante)) {
                turma.alunos.push(estudante);
            }
        }
    };

    turma.desmatricula = function (estudante) { // usar indexof
        let c = 0;
        turma.alunos.forEach(e => {
            if (e === estudante) {
                turma.alunos.splice(c, 1);
                break;
            };
            c++;
        });
    };

    return turma;
}


exports.professor = function professor(matricula, nome, email, cpf, url_foto) {
    let professor = Object.create(Object.prototype);

    professor.turmas = [];
    
    professor.nome = nome;
    professor.matricula = matricula;
    professor.email = email;
    professor.cpf = cpf;
    professor.foto = url_foto;

    professor.get_nome = () => professor.nome;
    professor.get_matricula = () => professor.matricula;
    professor.get_email = () => professor.email;
    professor.get_cpf = () => professor.cpf;
    professor.get_foto = () => professor.foto;
    professor.get_turmas = () => professor.turmas;

    professor.set_nome = (newNome) => professor.nome = newNome;

    professor.aloca_turma = function (t0) {
        professor.turmas.push(t0);
        t0.defineProf(this);
    }

    professor.turmas(semestre) {    // semestre sendo 19.2, 17.1, etc...
        
    }
    
    return professor;
}

exports.estudante = function estudante() {
    let estudante = Object.create(Object.prototype);

    return estudante;
}
