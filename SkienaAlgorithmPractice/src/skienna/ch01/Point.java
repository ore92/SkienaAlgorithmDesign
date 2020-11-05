package skienna.ch01;

import java.util.List;

/**
 * Defines a point in space.
 * 
 * @author ore
 *
 */
public interface Point<T extends Point<T>> {
	
	/**
	 * @return the distance between this point and two
	 */
	public double distanceTo(T two);
	
	/**
	 * 
	 * Returns the tsp distance given the ordering in points
	 * @param points list/ordering of points.
	 * @return tsp distance
	 */
	static double tspDistance(List<Point> points) {
		double dist = 0;
		for (int i = 0; i < points.size(); i++) {
			dist += points.get(i % points.size()).distanceTo(points.get((i + 1) % points.size()));
		}
		return dist;
	}
}
