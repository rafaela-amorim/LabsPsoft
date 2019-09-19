package comparators;

import java.util.Comparator;

import disciplinas.entities.Disciplina;


public class LikesComparator implements Comparator<Disciplina> {

	@Override
	public int compare(Disciplina d1, Disciplina d2) {
		return d1.getLikes() - d2.getLikes();
	} 

}
