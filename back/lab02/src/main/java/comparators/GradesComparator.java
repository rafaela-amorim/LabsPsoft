package comparators;

import java.util.Comparator;

import subjects.entities.Subjects;

public class GradesComparator implements Comparator<Subjects> {

	// da maior para a menor nota
	@Override
	public int compare(Subjects d1, Subjects d2) {
		return (int) (d2.getNota() - d1.getNota());
	}

}
