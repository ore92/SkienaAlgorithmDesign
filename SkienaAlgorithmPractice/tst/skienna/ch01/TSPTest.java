package skienna.ch01;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TSPTest {

	@Test
	public void testNearestNeighbor() {
		int[] numline1 = new int[] { -21, -5, -1, 0, 1, 3, 11 };
		// moved point 0 to starting point
		int[] numline2 = new int[] { 0, -21, -5, -1, 1, 3, 11 };

		List<Point> points1 = new ArrayList<Point>();
		for (int i = 0; i < numline1.length; i++) {
			points1.add(new EuclidDist2DPoint(numline1[i], 0));
		}

		List<Point> points2 = new ArrayList<Point>();
		for (int i = 0; i < numline2.length; i++) {
			points2.add(new EuclidDist2DPoint(numline2[i], 0));
		}

		TSP.nearestNeighbor(points1);
		TSP.nearestNeighbor(points2);

		assertTrue("reordering should increase distance", Point.tspDistance(points1) < Point.tspDistance(points2));
		assertEquals(64.0, Point.tspDistance(points1));
		assertEquals(72.0, Point.tspDistance(points2));
	}
	
	@Test
	public void testClosestPair() {
		int[] numline = new int[] { 0, -21, -5, -1, 1, 3, 11 };
		
		List<Point> points1 = new ArrayList<Point>();
		for (int i = 0; i < numline.length; i++) {
			points1.add(new EuclidDist2DPoint(numline[i], 0));
		}
		
		List<Point> solution1 = TSP.closestPair(points1);
		assertEquals(64.0, Point.tspDistance(solution1));
	}
	
	@Test
	public void testClosetPairWithRectangle() {
		double[][] points = { { 0, 0 }, { 1 + Math.exp(1), 0 }, { 2 * (1 + Math.exp(1)), 0 }, { 0, 1 - Math.exp(1) },
				{ 1 + Math.exp(1), 1 - Math.exp(1) }, { 2 * (1 + Math.exp(1)), 1 - Math.exp(1) } };
		List<Point> points1 = new ArrayList<Point>();
		for (int i = 0; i < points.length; i++) {
			points1.add(new EuclidDist2DPoint(points[i][0], points[i][1]));
		}
		List<Point> solution1 = TSP.closestPair(points1);
		double partialDist = Math.abs(3*(1 - Math.exp(1))) + Math.abs(2 * (1 + Math.exp(1)));
		double expectedSolution = partialDist + Math.sqrt((1 - Math.exp(1))*(1 - Math.exp(1)) +(2 + 2*Math.exp(1))*(2 + 2*Math.exp(1)));
		assertEquals(expectedSolution,Point.tspDistance(solution1), 0.00000000000001);
	}
	
	@Test
	public void testOptimalTSP() {
		int[] numline = new int[] { 0, -21, -5, -1, 1, 3, 11 };
		
		List<Point> points1 = new ArrayList<Point>();
		for (int i = 0; i < numline.length; i++) {
			points1.add(new EuclidDist2DPoint(numline[i], 0));
		}
		
		List<Point> solution1 = TSP.optimalTSP(points1);
		assertEquals(64.0, Point.tspDistance(solution1));
	}
	
	@Test
	public void testOptimalTSPWithRectangle() {
		double[][] points = { { 0, 0 }, { 1 + Math.exp(1), 0 }, { 2 * (1 + Math.exp(1)), 0 }, { 0, 1 - Math.exp(1) },
				{ 1 + Math.exp(1), 1 - Math.exp(1) }, { 2 * (1 + Math.exp(1)), 1 - Math.exp(1) } };
		List<Point> points1 = new ArrayList<Point>();
		for (int i = 0; i < points.length; i++) {
			points1.add(new EuclidDist2DPoint(points[i][0], points[i][1]));
		}
		List<Point> solution= TSP.optimalTSP(points1);
		double fastestTsp = Math.abs(2*(1 - Math.exp(1))) + Math.abs(4 * (1 + Math.exp(1)));
		assertEquals(fastestTsp, Point.tspDistance(solution));
	}
}
