package skienna.ch01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Solutions to the traveling salesman problem with a few heuristics
 * 
 * @author ore
 *
 */
public class TSP {

	/**
	 * Reorders the list of points solving TSP with the nearest-neighbor heuristic
	 * 
	 * @param points the points in space
	 */
	@SuppressWarnings("unchecked")
	public static void nearestNeighbor(List<Point> points) {
		for (int i = 0; i < points.size() - 1; i++) {
			Point cur = points.get(i);
			double curMin = Double.MAX_VALUE;
			int nextIndx = i + 1;

			for (int j = i + 1; j < points.size(); j++) {
				double distanceToCur = cur.distanceTo(points.get(j));
				if (distanceToCur < curMin) {
					curMin = distanceToCur;
					nextIndx = j;
				}
			}
			Collections.swap(points, i + 1, nextIndx);
		}
	}

	/**
	 * Returns an ordered list of points, solving the TSP with closest Pair
	 * heuristic
	 * 
	 * @param points the points in space
	 * @return the ordered path
	 */
	public static List<Point> closestPair(List<Point> points) {
		if (points.size() == 0)
			return points;
		LinkedList<LinkedList<Point>> frontier = new LinkedList<>();

		for (int i = 0; i < points.size(); i++) {
			LinkedList<Point> p = new LinkedList<Point>();
			p.add(points.get(i));
			frontier.add(p);
		}
		while (frontier.size() > 1) {
			int s = 0, e = s + 1;
			boolean connectToEnd = false;
			Double curMin = Double.MAX_VALUE;
			for (int i = 0; i < frontier.size(); i++) {
				List<Point> vertexChainE = frontier.get(i);
				Point v1 = vertexChainE.get(vertexChainE.size() - 1);
				for (int j = 0; j < frontier.size(); j++) {
					if (i == j)
						continue;
					List<Point> vertexChainS = frontier.get(j);
					Point v2Start = vertexChainS.get(0);
					Point v2End = vertexChainS.get(vertexChainS.size() - 1);
					double dist = v1.distanceTo(v2Start);
					double dist2 = v1.distanceTo(v2End);

					if (dist < curMin || dist2 < curMin) {
						e = i;
						s = j;
						if (dist2 < dist) {
							curMin = dist2;
							connectToEnd = true;
						} else {
							curMin = dist;
							connectToEnd = false;
						}
					}
				}
			}
			if (connectToEnd) {
				Collections.reverse(frontier.get(s));
			}
			frontier.get(e).addAll(frontier.get(s));
			frontier.remove(s);
		}
		return frontier.get(0);
	}

	public static List<Point> optimalTSP(List<Point> points) {
		if (points.size() > 7) {
			throw new IllegalArgumentException("Search space is too large for optimal TSP");
		}
		List<List<Point>> solutionSpace = optimalTSPHelper(points);
		double minDistanceSoFar = Double.MAX_VALUE;
		List<Point> bestSolution = null;
		for (List<Point> solution : solutionSpace) {
			double dist = Point.tspDistance(solution);
			if (dist < minDistanceSoFar) {
				minDistanceSoFar = dist;
				bestSolution = solution;
			}
		}
		return bestSolution;
	}

	private static List<List<Point>> optimalTSPHelper(List<Point> solutionFrontier) {
		List<List<Point>> ret = new ArrayList<List<Point>>();
		if (solutionFrontier.isEmpty()) {
			List<Point> points = new ArrayList<Point>();
			ret.add(points);
			return ret;
		}

		for (int i = 0; i < solutionFrontier.size(); i++) {
			List<Point> newFrontier = new ArrayList<Point>(solutionFrontier);
			Point choice = solutionFrontier.get(i);
			newFrontier.remove(i);
			List<List<Point>> subSolution = optimalTSPHelper(newFrontier);
			for (List<Point> solution : subSolution) {
				solution.add(choice);
				ret.add(solution);
			}
		}

		return ret;
	}
}
