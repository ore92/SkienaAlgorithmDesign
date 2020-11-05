package skienna.ch01;

import java.util.Collections;

import java.util.List;

/**
 * 
 * Given a set of intervals of movie production time, return the largest subset
 * with no overlaps
 * 
 * @author ore
 *
 */
public class MovieScheduling {

	public static void earliestEndTimeHeuristic(List<Interval> movies) {
		Collections.sort(movies, (movie1,movie2) -> Double.compare(movie1.getEnd(), movie2.getEnd()));
		double excludeCondition = Double.NEGATIVE_INFINITY;
		
		int i=0, j=-1;		
		while(i < movies.size()) {
			if(movies.get(i).getStart() > excludeCondition) {
				j++;
				movies.set(j, movies.get(i));
				excludeCondition = movies.get(j).getEnd();
			}
			i++;
		}
		
		i--;
		while(i > j) {
			movies.remove(i);
			i--;
		}
	}
}
