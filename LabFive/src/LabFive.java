import java.util.*;

public class LabFive {
	// Problem 1
	public static <T extends Comparable<? super T>> boolean inArrayIterativeSorted(T[] anArray, T anEntry) {
		int startIndex = 0;
		int lastIndex = anArray.length - 1;
		int middle = startIndex + ((lastIndex - startIndex) / 2);

		while (startIndex <= lastIndex) {
			if (anEntry.equals(anArray[middle])) {
				return true;
			} else if (0 < (anEntry.compareTo(anArray[middle]))) {
				startIndex = middle + 1;

			} else {
				lastIndex = middle - 1;

			}
		}

		return false;
	}

	// Problem 2
	public static <T extends Comparable<? super T>> Interval findInterval(T[] sortedData, List<T> targetValues) {

		T max; // minimum of list
		T min; // maximum of list
		min = targetValues.get(0);
		max = targetValues.get(0);
		for (int i = 1; i < targetValues.size(); i++) { // gets the minimum and maximum value of the target values, as
														// we only need the upper and lower bounds to compute interval
			if (0 < min.compareTo(targetValues.get(i)))
				min = targetValues.get(i);
			if (0 > max.compareTo(targetValues.get(i)))
				max = targetValues.get(i);

		}


		int start = 0;
		int end = 0;
		if (0 < sortedData[0].compareTo(min)) // if the first value of the sorted data us less than the minimum target
												// value, we automatically start interval at -1
		{
			start = -1;
		} else {
			for (int i = 1; i < sortedData.length; i++) { // manually finds the end index of the array
				if (0 < sortedData[i].compareTo(min)) {	  // if(data[i]<List's min Value)
					start = i - 1;
				break;
				}
			}

		}
		if (0 > sortedData[sortedData.length - 1].compareTo(max)) { // if end value of sorted data is greater than maximum target, 
			end = sortedData.length ;							    // end of interval automatically ends at n-1 (or the length of the sorted data)

		} else {

			for (int i = 0; i < sortedData.length; i++) { // manually finds the end index of the array
				if (0 < sortedData[i].compareTo(max)) {// finds the maximum index range
					end = i;
					break; // since data is sorted, once we find the end interval we dont need to keep
							// iterating the loop as any data beyond the end interval is out of range
				}
			}
		}
		Interval answer = new Interval(start, end);
		return answer;

	}

	// Problem 3
	public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
		for (int i = 1; i < a.length; i++) {
			if (0 < a[i - 1].compareTo(a[i]))
				return false;
		}
		return true;
	}

	// Problem 4
	public static <T extends Comparable<? super T>> void modifiedSelectionSort(T[] a, int n) {
		// assuming n is number of elements in the array that you want to be sorted
		int minIndex;
		int maxIndex;

		for (int i = 0; i < n / 2; i++) {
			minIndex = i;
			maxIndex = i;
			// Finding the least value in an array and performing the swap
			for (int j = i + 1; j <= n - (i + 1); j++) {
				if (0 > a[j].compareTo(a[minIndex])) {

					minIndex = j;
				}
			}
			T min1 = a[i];
			T min2 = a[minIndex];
			a[i] = min2;
			a[minIndex] = min1;
		

			// Finding greatest value in an array and performing the swap
			for (int j = i + 1; j <= n - (i + 1); j++) {
				if (0 < a[j].compareTo(a[maxIndex])) {

					maxIndex = j;
				}

			}

			T max1 = a[n - (i + 1)];
			T max2 = a[maxIndex];
			a[n - (i + 1)] = max2;
			a[maxIndex] = max1;

		}

	}
}
