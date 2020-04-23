//Richard Yu, Lab Seven Tester
public class LabSevenTester {
	public static void main(String[] args) {
		// findMissingTester();
		// countingSortTester();
		// findMedianTester();

	}

	// Tester for findMedian
	public static void findMedianTester() {
		int[] a = { 3, 43, 2, 14, 23, 54, 32, 45 };
		int[] b = { -24, 25 };
		int[] c = { -6, -9, -1, -3, -5, -7, -10, -4, -2, -8 };
		int[] d = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] e = { 34 };
//		//testing to make sure  FindKSmallest() works
//		System.out.println("Testing for FindKSmallest() for all possible k with {-6,-9,-1,-3,-5,-7,-10,-4,-2,-8} ");
//		for(int i =1;i<=c.length;i++) {
//			System.out.println(ArraySort.findKSmallest(c,i));
//		}
//		System.out.println("Testing for FindKSmallest() for all possible k {3,43,2,14,23,54,32,45}");
//		for(int i =1;i<=a.length;i++) {
//			System.out.println(ArraySort.findKSmallest(a,i));
//		}
		System.out.println("Testing findMedian with {1,2,3,4,5,6,7,8,9},a sorted array, median value is "
				+ ArraySort.findMedian(d));
		System.out.println(
				"Testing findMedian with {-6,-9,-1,-3,-5,-7,-10,-4,-2,-8}, a unsorted array with all negative values, Median value is "
						+ ArraySort.findMedian(c));
		System.out.println(
				"Testing findMedian with {3,43,2,14,23,54,32,45}, a unsorted array with all positive values. Median value is "
						+ ArraySort.findMedian(a));
		System.out.println(
				"Testing findMedian with {34}, an array with one value. Median value is " + ArraySort.findMedian(e));
		System.out.println("Testing findMedian with {25,-24}, an array with two values. Median value is "
				+ ArraySort.findMedian(b));

	}

	// Tester for findMissing
	public static void findMissingTester() {
		int a[] = { 3, 6, 5, 1, 4 };
		System.out.println("With array {3,6,5,1,4}, FindMissing() returns " + ArraySort.findMissing(a));
		int b[] = { 4, 7, 5, 2, 6, 1 };
		System.out.println("With array {4,7,5,2,6,1}, FindMissing() returns " + ArraySort.findMissing(b));
		int c[] = { 6, 7, 8, 1, 3, 2, 4 };
		System.out.println("With array {6,7,8,1,3,2,4}, FindMissing() returns " + ArraySort.findMissing(c));
	}

	// Tester for counting sort
	public static void countingSortTester() {
		int a[] = { 9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5 };
		ArraySort.countingSort(a, 9);
		System.out.println(
				"After calling countingSort with array {9,2,4,8,9,4,3,2,8,1,2,7,2,5} with n=9, the array is now:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int b[] = { 1, 3, 2, 1, 3, 4, 3, 5 };
		ArraySort.countingSort(b, 5);
		System.out.println("After calling countingSort with array {1,3,2,1,3,4,3,5} with n=5, the array is now:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		int c[] = { 7, 6, 5, 4, 3, 2, 1 };
		ArraySort.countingSort(c, 7);
		System.out.println("After calling countingSort with array {7,6,5,4,3,2,1}; with n=7, the array is now:");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}

	}

}
