/**
   A class that implements the ADT list by using a chain of nodes.
   The chain has both a head reference and a tail reference.
   @author Frank M. Carrano
   @version 3.0
*/
public class LList2<T> implements ListInterface<T>
{
	private Node firstNode; // head reference to first node
	private Node lastNode;  // tail reference to last node
	private int  numberOfEntries;

	public LList2()
	{
		clear();
	} // end default constructor

	public final void clear() // NOTICE clear is not final in interface and that is OK
	{
		firstNode = null;
  		lastNode = null;
		numberOfEntries = 0;
	} // end clear
  
	public void add(T newEntry) 	  // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry); // create new node

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
  		lastNode = newNode;
  		numberOfEntries++;
	}  // end add

   public boolean add(int newPosition, T newEntry)  // OutOfMemoryError possible	                                                 
	{
      boolean isSuccessful = true;

      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) 
      {
         Node newNode = new Node(newEntry);

         if (isEmpty())
         {
            firstNode = newNode;
            lastNode = newNode;
         }
         else if (newPosition == 1)
         {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
         }
         else if (newPosition == numberOfEntries + 1)
         {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
         } 
         else
         {
            Node nodeBefore = getNodeAt(newPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         } // end if	    
         numberOfEntries++;
      }
      else
         isSuccessful = false;
       
	   return isSuccessful;
	} // end add

	public T remove(int givenPosition)
	{
      T result = null;                 // return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         if (givenPosition == 1)        // case 1: remove first entry
         {
            result = firstNode.getData();     // save entry to be removed 
            firstNode = firstNode.getNextNode();
            if (numberOfEntries == 1)
               lastNode = null; // solitary entry was removed
            }
            else                           // case 2: givenPosition > 1
            {
               Node nodeBefore = getNodeAt(givenPosition - 1);
               Node nodeToRemove = nodeBefore.getNextNode();
               Node nodeAfter = nodeToRemove.getNextNode();
               nodeBefore.setNextNode(nodeAfter);  // disconnect the node to be removed
               result = nodeToRemove.getData();  // save entry to be removed

               if (givenPosition == numberOfEntries)
                  lastNode = nodeBefore; // last node was removed
         } // end if

         numberOfEntries--;
      } // end if

      return result;                   // return removed entry, or 
                                      // null if operation fails
	} // end remove

	public boolean replace(int givenPosition, T newEntry)
	{
		boolean isSuccessful = true;

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {   
      	assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			desiredNode.setData(newEntry);
      }    
		else
			isSuccessful = false;
			
		return isSuccessful;
   } // end replace

   public T getEntry(int givenPosition)
   {
      T result = null;  // result to return
      
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
         result = getNodeAt(givenPosition).getData();
     	} // end if
      
      return result;
   } // end getEntry

	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
		
		return found;
	} // end contains

   public int getLength()
   {
      return numberOfEntries;
   } // end getLength

   public boolean isEmpty()
   {
   		boolean result;
   		
      	if (numberOfEntries == 0) // or getLength() == 0
      	{
      		assert firstNode == null;
      		result = true;
      	}
      	else
      	{
      		assert firstNode != null;
      		result = false;
      	} // end if
      	
      	return result;
   } // end isEmpty
	
   public T[] toArray()
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // warning: [unchecked] unchecked cast

	  int index = 0;
     Node currentNode = firstNode;
	  while ((index < numberOfEntries) && (currentNode != null))
	  { 
	    result[index] = currentNode.getData();
	    currentNode = currentNode.getNextNode();
       index++; 
	  } // end while
     
     return result;
   } // end toArray

	// Returns a reference to the node at a given position.
	// Precondition:  List is not empty; 1 <= givenPosition <= numberOfEntries.	
	private Node getNodeAt(int givenPosition)
	{
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
      if (givenPosition == numberOfEntries)
         currentNode = lastNode;
      else if (givenPosition > 1)      // traverse the chain to locate the desired node
		{
         for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
		} // end if
      
		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

	// Lab 3
	// Problem 1
	int getLastIndex(T item) {
		int answer = -1;
		for (int i =0;i<numberOfEntries;i++) {
			if((getNodeAt(i).getData()).equals(item)) {
				answer = i;
			}
		}
		return answer;
	}
	// Problem 2
	int removeEvery(T item) {
	
		int answer = 0;
	
		for (int i =1;i<=numberOfEntries;i++) {
		
			if((getNodeAt(i).getData()).equals(item)) {
				remove(i);
				answer++;
				i--;
				
			}
		}
		return answer;
	}
	// Problem 3
	public boolean equals(Object other) {
		T[] temp =  ((ListInterface<T>) other).toArray();

		   if((!(temp.length==numberOfEntries))) {// if the lengths are not equal it is impossible for both lists to be equal
			
			   return false;
			   }
			   for (int i =1;i<=numberOfEntries;i++) {
				   if(!(getEntry(i).equals(temp[i-1]))) {
					   
					   return false;		// only need one instance of a mismatched item for lists to be unequal
				   }
			   }
			   return true;
	   
		
	}
	
	//Problem 4
	boolean contains2(T anEntry) {
		Node startNode = getNodeAt(1);
		return contains(anEntry,startNode);
		
	}
	private boolean contains(T anEntry, Node startNode) {
		if(startNode.getData().equals(anEntry)) {
			return true;
		}
		if(startNode.next == null)
			return false;
		
		startNode= startNode.getNextNode();
		return contains(anEntry,startNode);
		
	}
	
	
	private class Node 
	{
		private T data;  // data portion
		private Node next;  // next to next node

		private Node(T dataPortion)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = null;	
		} // end constructor

		private Node(T dataPortion, Node nextNode)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData
		
		private void setData(T newData)
		{
			data = newData;
		} // end setData
		
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LList2

