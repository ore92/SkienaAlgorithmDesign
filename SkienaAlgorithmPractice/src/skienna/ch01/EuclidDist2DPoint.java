package skienna.ch01;

public class EuclidDist2DPoint implements Point<EuclidDist2DPoint> {
	private final double x;
	private final double y;
	
	public EuclidDist2DPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public double distanceTo(EuclidDist2DPoint two) {
		return Math.sqrt((x-two.x)*(x-two.x) + (y-two.y)*(y-two.y));
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
