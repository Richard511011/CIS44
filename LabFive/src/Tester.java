import java.util.*;

public class Tester {
	public static void main(String[] args) {
		findIntervalTest();
		//	isSortedTest();
		// inArrayIterativeSortedTest();
		// modifiedSelectionSortTest();
		
	}
	public static void findIntervalTest() {
		Integer[] a = { 5, 8, 10, 13, 15, 20, 22, 26 };
		Integer[] b = {-5,-3,-1,1,3,5,7,9,11,13};
		ArrayList<Integer> values1 = new ArrayList<Integer>();
		values1.add(8);
		values1.add(2);
		values1.add(9);
		values1.add(17);
		//Test 1 with array { 5, 8, 10, 13, 15, 20, 22, 26 } and target values (8,2,9,17)
		Interval answer = LabFive.findInterval(a, values1);
		System.out.println("Test 1 range is from "+ answer.getLower()+" to "+answer.getUpper());
		values1.add(100);
		//Test 2 with array { 5, 8, 10, 13, 15, 20, 22, 26 } and target values (8,2,9,17,100), where an entry in target values exceeds data[n-1]
		answer = LabFive.findInterval(a, values1);
		System.out.println("Test 2 range is from "+ answer.getLower()+" to "+answer.getUpper());
		values1.remove(4);
		values1.remove(3);
		values1.add(-2);
		//Test 3 with array {-5,-3,-1,1,3,5,7,9,11,13}; and target values (8,2,9,-2)
		answer = LabFive.findInterval(b, values1);
		System.out.println("Test 3 range is from "+ answer.getLower()+" to "+answer.getUpper());
		
	}
	//Tester for isSorted();
	public static void isSortedTest() {
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Integer[] c = { 1, 1, 1, 1, 1, 1 };
		Integer[] d = { 1,2,3,4,5,6,7,9,8};
		//with a sorted array
		System.out.println("Testing for is Sorted \nWith the array {1,2,3,4,5,6,7,8} isSorted returns "+LabFive.isSorted(a));
		//with a array of same values
		System.out.println("With the array { 1, 1, 1, 1, 1, 1 } isSorted returns "+LabFive.isSorted(c));
		//with an array that is not sorted in ascending order 
		System.out.println("With the array {1,2,3,4,5,6,7,9,8} isSorted returns "+LabFive.isSorted(d));
	}
	
	// Tester for binary search
	public static void inArrayIterativeSortedTest() {
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Integer[] c = { 1, 1, 1, 1, 1, 1 };
		Integer[] d = { 3, 4, 5, 6, 7, 8, 9 };
		Integer b = 5;
		System.out.println("Testing for inArrayIterativeSorted\nwith array {1,2,3,4,5,6,7,8,9,10} and 3");
		System.out.println("inArrayIterativeSorted() returns: " + LabFive.inArrayIterativeSorted(a, b));
		b = 1;
		// with array of same values
		System.out.println("With array{1,1,1,1,1,1} and 1");
		System.out.println("inArrayIterativeSorted() returns: " + LabFive.inArrayIterativeSorted(c, b));
		b = 9;
		// with Odd array length
		System.out.println("With array{3,4,5,6,7,8,9} and 9");
		System.out.println("inArrayIterativeSorted() returns: " + LabFive.inArrayIterativeSorted(d, b));
		b = 2;
		// with a value that is not contained in the array
		System.out.println("With array{3,4,5,6,7,8,9} and 2");
		System.out.println("inArrayIterativeSorted() returns: " + LabFive.inArrayIterativeSorted(c, b));

	}

	// Tester for modifiedSelectionSort()
	public static void modifiedSelectionSortTest() {
		Integer[] c = { 7, 8, 3, 1, 4, 2, 5, 9, 6 };
		// input of an array of odd length
		LabFive.modifiedSelectionSort(c, c.length);
		System.out.println("Testing for modifiedSelectionSort");
		System.out.println("input array {7,8,3,1,4,2,5,9,6}");
		System.out.println("sorted array is now:");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		Integer[] d = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// input of an array with even length and is already sorted
		System.out.println("\ninput array {1,2,3,4,5,6,7,8,9,10}");
		System.out.println("sorted array is now:");
		LabFive.modifiedSelectionSort(d, d.length);
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		// input of an array with all equal values
		Integer[] e = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println("\ninput array {1,1,1,1,1,1,1,1,1,1}");
		System.out.println("sorted array is now:");
		LabFive.modifiedSelectionSort(e, e.length);
		for (int i = 0; i < e.length; i++) {
			System.out.print(e[i] + " ");
		}
		// input of an array with random integers
		Integer[] f = { 8, 34, 65, 103, 53, 111, -91, 54, -54, 18 };
		System.out.println("\ninput array {8,34,65,103,53,111,-91,54,-54,18}");
		System.out.println("sorted array is now:");
		LabFive.modifiedSelectionSort(f, f.length);
		for (int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}

	}
}
