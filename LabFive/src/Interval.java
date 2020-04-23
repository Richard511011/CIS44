
public class Interval {
	private static int upper;
	private static int lower;

	public Interval(int lower, int upper) {
		this.upper = upper;
		this.lower = lower;
	}

	public static int getLower() {
		return lower;
	}

	public static int getUpper() {
		return upper;

	}

}
