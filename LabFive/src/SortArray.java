import java.util.* ;
public class SortArray
{
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
	for (int index = 0; index < n - 1; index++)
	    {
		int indexOfSmallest = indexOfSmallest(a, index, n - 1);
		T temp = a[index];
		a[index] = a[indexOfSmallest];
		a[indexOfSmallest] = temp; 
		//Invariant: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]
	    } // end for
    } // end selectionSort
    
    private static <T extends Comparable<? super T>>
			      int indexOfSmallest(T[] a, int first, int last) {
	T min = a[first];
	int indexOfMin = first;
	for (int index = first + 1; index <= last; index++)
	    {
		if (a[index].compareTo(min) < 0)
		    {
			min = a[index];
			indexOfMin = index;
         } 
	    } 
	return indexOfMin;
    } 

    public static <T extends Comparable<? super T>>
			     void insertionSort(T[] a, int n) {
	for(int unsorted = 1; unsorted < n; ++unsorted) {
	    T item = a[unsorted];
	    int loc = unsorted;
	    while(loc > 0 && a[loc-1].compareTo(item) > 0) {
		a[loc] = a[loc-1];
		--loc;
	    }
	    a[loc] = item;
	}	
    }

    public static <T extends Comparable<? super T>>
			     void bubbleSort(T[] a, int n) {
	
	for(int pass = 1; pass < n ; ++pass) {
	    for(int index = 0; index < n-pass; ++index) {
		int nextIndex = index + 1;
		if(a[index].compareTo(a[nextIndex]) > 0) {
		    T temp = a[index];
		    a[index] = a[nextIndex];
		    a[nextIndex] = temp;
		}
	    }
	}	 
    }

    public static <T extends Comparable<? super T>>
			     void bubbleSort2(T[] a, int n) {
	boolean sorted = false;
	for(int pass = 1; pass < n && !sorted ; ++pass) {
	    sorted = true;
	    for(int index = 0; index < n-pass; ++index) {
		int nextIndex = index + 1;
		if(a[index].compareTo(a[nextIndex]) > 0) {
		    T temp = a[index];
		    a[index] = a[nextIndex];
		    a[nextIndex] = temp;
		    sorted = false;
		}
	    }
	}	 
    }
    
    public static void main(String [] args) {
	Integer [] a = { 15, 8 , 10 , 2, 5 };
	//selectionSort(a, a.length);
	//insertionSort(a, a.length);
	//bubbleSort(a, a.length);
	bubbleSort2(a, a.length);
	System.out.println("a = " + Arrays.toString(a));
    }
    
} // end SortArray
