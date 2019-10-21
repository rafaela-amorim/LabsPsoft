// para executar o mocha faz:
// ./node_modules/mocha/bin/mocha

let assert = require('assert');

let disciplina = require('./scoord').disciplina;
let turma = require('./scoord').turma;

describe('factory Disciplina', function() {
  let d0;

    before(async () => {
        d0 = disciplina('prog1', 'Programação 1', 4, []);
    })

    it('deve criar disciplinas distintas a cada invocação', function(){
        d0 = disciplina('prog1', 'Programação 1', 4, []);
        d1 = disciplina('prog1', 'Programação 1', 4, []);
        d2 = disciplina('prog1', 'Programação 1', 4, []);
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('prog1', d0.id());
        assert.equal('Programação 1', d0.get_nome());
        assert.equal(4, d0.creditos);
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('deve permitir atualização de nome', function(){
        d0.set_nome('Programação de Computadores I')
        assert.equal('prog1', d0.id());
        assert.equal('Programação de Computadores I', d0.get_nome());
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('não deve permitir atualização de id via set_id', function(){
        assert.throws(function () {
            d0.set_id('outro')
        }, TypeError);
        assert.equal('prog1', d0.id());
    });

});


describe('factory Turma', function() {
    let t0;
    let aa;

    before(async () => {
        t0 = turma(aa, 2);
    });

    /*
    it('deve definir um professor para a turma', function() {

    });*/

    it('verifica se set_status esta funcionando', function() {
        assert.equal(t0.get_status(), "planejada");
        
        t0.set_status("ativa");
        assert.equal(t0.get_status(), "ativa");
        
        t0.set_status("all >>>> javascript");
        assert.equal(t0.get_status(), "ativa");

        t0.set_status("concluida");
        assert.equal(t0.get_status(), "ativa");

        t0.set_status("concluída");
        assert.equal(t0.get_status(), "concluída");
    });

    // it('verifica se está matriculando um estudante')

});