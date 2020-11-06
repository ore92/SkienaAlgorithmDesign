package skienna.ch01;

import java.util.ArrayList;
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
	
	/**
	 * Returns a subset of non-overlapping intervals using the earliest time
	 * heuristic. This heuristic is not optimal for returning the largest possible
	 * non overlapping subset
	 * 
	 * @param movies the movie intervals
	 */
	public static void earliestStartTimeHeuristic(List<Interval> movies) {
		Collections.sort(movies, (movie1, movie2) -> Double.compare(movie1.getStart(), movie2.getStart()));
		double inclusionThreshold = Double.NEGATIVE_INFINITY;
		int i = 0, j = -1;
		while (i < movies.size()) {
			boolean inclusionCondition = movies.get(i).getStart() > inclusionThreshold;
			if (inclusionCondition) {
				j++;
				movies.set(j, movies.get(i));
				inclusionThreshold = movies.get(j).getEnd();
			}
			i++;
		}
		i--;
		while (i > j) {
			movies.remove(i);
			i--;
		}
	}
	
	/**
	 * Returns a subset of non-overlapping intervals using the shortest interval
	 * heuristic. This heuristic is not optimal for returning the largest possible
	 * non-overlapping set
	 * 
	 * @param movies the movie intervals
	 * @return
	 */
	public static List<Interval> shortestIntervalHeuristic(List<Interval> movies) {
		Collections.sort(movies, (movie1, movie2) -> Double.compare(movie1.getEnd() - movie1.getStart(),
				movie2.getEnd() - movie2.getStart()));
		List<Interval> includedIntervals = new ArrayList<Interval>();
		for (int i = 0; i < movies.size(); i++) {
			boolean inclusionCondition = true;
			for (int j = 0; j < includedIntervals.size(); j++) {
				boolean exclusionCriteria = movies.get(i).getEnd() > movies.get(j).getStart()
						&& movies.get(i).getStart() < movies.get(j).getEnd();

				if (exclusionCriteria) {
					inclusionCondition = false;
					break;
				}

			}
			if (inclusionCondition) {
				includedIntervals.add(movies.get(i));
			}
		}
		return includedIntervals;
	}
	
	/**
	 * Returns a subset of non-overlapping movie intervals using the optimal
	 * end-time heuristic
	 * 
	 * @param movies the movie intervals
	 */
	public static void earliestEndTimeHeuristic(List<Interval> movies) {
		Collections.sort(movies, (movie1, movie2) -> Double.compare(movie1.getEnd(), movie2.getEnd()));
		double inclusionCondition = Double.NEGATIVE_INFINITY;

		int i = 0, j = -1;
		while (i < movies.size()) {
			if (movies.get(i).getStart() > inclusionCondition) {
				j++;
				movies.set(j, movies.get(i));
				inclusionCondition = movies.get(j).getEnd();
			}
			i++;
		}

		i--;
		while (i > j) {
			movies.remove(i);
			i--;
		}
	}
}
