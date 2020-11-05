package skienna.ch01;

import java.util.Arrays;

/**
 * POJO object for storing intervals
 * 
 * @author ore
 *
 */
public class Interval {
	final double[] interval = new double[2];

	/**
	 * @param start start
	 * @param end   end
	 */
	public Interval(double start, double end) {
		if (start > end) {
			throw new IllegalArgumentException("start time cannot be greater than end time");
		}
		interval[0] = start;
		interval[1] = end;
	}

	/**
	 * @return start point
	 */
	public double getStart() {
		return interval[0];
	}

	/**
	 * @return end point
	 */
	public double getEnd() {
		return interval[1];
	}
	
	@Override
	public String toString() {
		return "start:" + getStart() + " end:" + getEnd();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(interval);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (!Arrays.equals(interval, other.interval))
			return false;
		return true;
	}

}
