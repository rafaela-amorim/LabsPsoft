package comparators;

import java.util.Comparator;

import subjects.entities.Subjects;

public class LikesComparator implements Comparator<Subjects> {

	@Override
	public int compare(Subjects d1, Subjects d2) {
		return d1.getLikes() - d2.getLikes();
	} 

}
