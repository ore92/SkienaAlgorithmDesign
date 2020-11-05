package skienna.ch01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 
 * Test for {@link MovieScheduling.class}
 * 
 * @author ore
 *
 */
public class MovieSchedulingTest {
	
	@Test
	public void testEarliestEndTimeHeuristic() {
		List<Interval> test1 = new ArrayList<>(Arrays.asList(new Interval(0,3), new Interval(1,5), new Interval (4,6)));
		List<Interval> test2 = new ArrayList<>(Arrays.asList(new Interval(0,3), new Interval(4,5)));
		List<Interval> test3 = new ArrayList<>(Arrays.asList(new Interval(0,9), new Interval(1,4), new Interval(5,7)));

		MovieScheduling.earliestEndTimeHeuristic(test1);
		
		assertEquals(2, test1.size());
		Collections.sort(test1, (interval1, interval2) -> Double.compare(interval1.getStart(),interval2.getEnd()));
		assertEquals(test1, Arrays.asList(new Interval(0,3), new Interval(4,6)));
		
		MovieScheduling.earliestEndTimeHeuristic(test2);
		
		assertEquals(2, test2.size());
		Collections.sort(test2, (interval1, interval2) -> Double.compare(interval1.getStart(),interval2.getEnd()));
		assertEquals(test2, Arrays.asList(new Interval(0,3), new Interval(4,5)));
		
		MovieScheduling.earliestEndTimeHeuristic(test3);
		
		assertEquals(2, test3.size());
		Collections.sort(test3, (interval1, interval2) -> Double.compare(interval1.getStart(),interval2.getEnd()));
		assertEquals(test3, Arrays.asList(new Interval(1,4), new Interval(5,7)));
	}
}
