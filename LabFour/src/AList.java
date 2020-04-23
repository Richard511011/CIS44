import java.util.Arrays;
/**
   A class that implements the ADT list by using an array.
   The list is never full.
   @author Frank M. Carrano
*/
public class AList<T> implements ListInterface<T> 
{
    private T[] list;   // array of list entries
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;  
    
    public AList() {
	this(DEFAULT_INITIAL_CAPACITY); // call next constructor
    } // end default constructor
    
    public AList(int initialCapacity) {
	numberOfEntries = 0;
	// the cast is safe because the new array contains null entries
	@SuppressWarnings("unchecked")
	    T[] tempList = (T[])new Object[initialCapacity];
	list = tempList; 
    } // end constructor
    
    public void add(T newEntry) {  
	ensureCapacity();
	list[numberOfEntries] = newEntry;
	numberOfEntries++;
    } // end add
    
    
    public boolean add(int newPosition, T newEntry) {  
	boolean isSuccessful = true;
	if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {	
	    ensureCapacity();
	    makeRoom(newPosition);				
	    list[newPosition - 1] = newEntry;
	    numberOfEntries++;
	}
	else
	    isSuccessful = false;
	return isSuccessful;
	
    } // end add
    
    public T remove(int givenPosition) { 
	
	T result = null; // return value

	if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {	
	    assert !isEmpty();
	    result = list[givenPosition - 1]; // get entry to be removed
	    
	    // move subsequent entries towards entry to be removed, 
	    // unless it is last in list
	    if (givenPosition < numberOfEntries)
		removeGap(givenPosition);
	    
	    numberOfEntries--;
	} // end if
	
	return result; // return reference to removed entry, or
	// null if either list is empty or givenPosition
	// is invalid
	
    } // end remove

    public void clear() { 
	numberOfEntries = 0;
    } // end clear

    public boolean replace(int givenPosition, T newEntry)  { 
	boolean isSuccessful = true;
	
	if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) { // test catches empty list 
	    assert !isEmpty();
	    list[givenPosition - 1] = newEntry;
	}
	else
	    isSuccessful = false;
	
	return isSuccessful;
	
    } // end replace
    
    public T getEntry(int givenPosition)  { 
	T result = null; // result to return
	
	if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
	    assert !isEmpty();
	    result = list[givenPosition - 1];
	} // end if
	
	return result;
	
    } // end getEntry
    
    public boolean contains(T anEntry) { 
	boolean found = false;
	for (int index = 0; !found && (index < numberOfEntries); index++) {
	    if (anEntry.equals(list[index]))
		found = true;
	} // end for
	
	return found;
    } // end contains
    
    public int getLength() {
	return numberOfEntries;
    } // end getLength
    
    public boolean isEmpty() {
	return numberOfEntries == 0; // or getLength() == 0
    } // end isEmpty
    
    public T[] toArray() {
	// the cast is safe because the new array contains null entries
	@SuppressWarnings("unchecked")
	    T[] result = (T[])new Object[numberOfEntries];
	
	for (int index = 0; index < numberOfEntries; index++) {
	    result[index] = list[index];
	} // end for
	
	return result;
    } // end toArray
    
    // Doubles the size of the array list if it is full.
    private void ensureCapacity() {
	if (numberOfEntries == list.length)
	    list = Arrays.copyOf(list, 2 * list.length);
    } // end ensureCapacity
    
    private void makeRoom(int newPosition) {
	assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
	
	int newIndex = newPosition - 1;
	int lastIndex = numberOfEntries - 1;
	
	// move each entry to next higher index, starting at end of
	// list and continuing until the entry at newIndex is moved
	for (int index = lastIndex; index >= newIndex; index--)
	    list[index + 1] = list[index];
    }  // end makeRoom
    
    private void removeGap(int givenPosition) {
	assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
	
	int removedIndex = givenPosition - 1;
	int lastIndex = numberOfEntries - 1;
	
	for (int index = removedIndex; index < lastIndex; index++)
	    list[index] = list[index + 1];
    } // end removeGap
   
   
   public int getLastIndex(T item) {
	  for(int i = list.length-1;i>=0;i--) {
		  if(item==list[i]) {
			  return i+1;
		  }
		 
	  }
	  return -1;
   }
   
   public boolean equals(Object other) {
	T[] temp =  ((ListInterface<T>) other).toArray();

	   if((!(temp.length==numberOfEntries))) {// if the lengths are not equal it is impossible for both lists to be equal
		
		   return false;
		   }
		   for (int i =0;i<numberOfEntries;i++) {
			   if(((!list[i].equals(temp[i])))) {
				   
				   return false;		// only need one instance of a mismatched item for lists to be unequal
			   }
		   }
		   return true;
   
   }
   
   public int removeEvery(T item) {
	   int answer = 0 ;
	   for(int i =0;i<numberOfEntries;i++) {
		   if (list[i].equals(item)) {
			 remove(i+1);
			   answer++;
		   }
	   }
	  
	   
	   return answer;
   }
   
   
} // end AList