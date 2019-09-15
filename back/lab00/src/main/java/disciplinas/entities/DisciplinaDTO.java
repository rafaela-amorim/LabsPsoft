package disciplinas.entities;

public class DisciplinaDTO implements Comparable {

	private String nome;
	private double nota;
	
	public DisciplinaDTO(String nome, double nota) {
		this.nome = nome;
		this.nota = nota;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getNota() {
		return nota;
	}

	@Override
	public int compareTo(Object disciplina) {
		return (int) (this.nota - ((DisciplinaDTO) disciplina).getNota());
	}
	
	
}
