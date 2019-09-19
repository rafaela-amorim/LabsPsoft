package comparators;

import java.util.Comparator;

import disciplinas.entities.Disciplina;


public class GradesComparator implements Comparator<Disciplina> {

	// da maior para a menor nota
	@Override
	public int compare(Disciplina d1, Disciplina d2) {
		return (int) (d2.getNota() - d1.getNota());
	}

}
