import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V> {
	private Node firstNode;
	private int numberOfEntries;

	public UnsortedLinkedDictionary() {// creates an UnsortedLinkedDictionary that is empty
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	public V add(K key, V value) {//With this implementation of add, we assume that each key has a single value. 
								  //Also if the user wants to add a key value pair and the key already exists in the dictionary, add() will replace that key's old value with a new given value
	   boolean found = false;
	   Node currentNode = firstNode;
		while((currentNode!=null)&&(found==false)) {
			if(currentNode.getKey().equals(key)) {
				currentNode.setValue(value);
				return currentNode.getValue();
				
			}
			currentNode=currentNode.getNextNode();
		}
		if(found == false) {	// If Key is not in the dictionary, we add it into the dictionary
			currentNode = firstNode;
			firstNode = new Node(key,value,currentNode);
			numberOfEntries++;
			return firstNode.getValue();
			
		}
		return firstNode.getValue();	
	   
   } // end add

	public V remove(K key) {
		Node currentNode = firstNode;
		if((currentNode!=null)&&(currentNode.getKey()).equals(key)) { // first checks the value of the head node
			firstNode=currentNode.getNextNode();
			numberOfEntries--;
			return currentNode.getValue();
		}
	
		while ((currentNode!=null)&&currentNode.getNextNode() != null) { // While we havent reached the end of the dictionary
			if (((currentNode.getNextNode()).getKey()).equals(key)) {//If we locate the removal node
				numberOfEntries--;
				V value = currentNode.getNextNode().getValue();
				currentNode.setNextNode((currentNode.getNextNode()).getNextNode());  // set the node before the removal node to reference the node after the removal node 
				return value; //returns the value associated with the removed node
			}
			currentNode = currentNode.getNextNode();
			
		}

		return null;// returns null if no removal node is found
	} // end remove

	public V getValue(K key) {
		Node currentNode = firstNode;
		while ((currentNode != null)) {
			if ((currentNode.getKey()).equals(key))
				return currentNode.getValue();	//returns the value linked to the key
			currentNode = currentNode.getNextNode();
		}
		return null; // returns null if no key is found
	} // end getValue

	public boolean contains(K key) {

		Node currentNode = firstNode;
		while ((currentNode != null)) {
			if ((currentNode.getKey()).equals(key))
				return true;
			currentNode = currentNode.getNextNode();
		}
		return false;

	} // end contains

	public boolean isEmpty() {
		if (numberOfEntries == 0)
			return true;
		return false;
	} // end isEmpty

	public int getSize() {
		return numberOfEntries;
	} // end getSize

	public final void clear() {
		firstNode = null;
		numberOfEntries=0;
	} // end clear

//	public Iterator<K> getKeyIterator() {
//
//	} // end getKeyIterator
//
//	public Iterator<V> getValueIterator() {
//
//	} // end getValueIterator

	private class Node {
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
			next = null;
		} // end constructor

		private Node(K searchKey, V dataValue, Node nextNode) {
			key = searchKey;
			value = dataValue;
			next = nextNode;
		} // end constructor

		private K getKey() {
			return key;
		} // end getKey

		private V getValue() {
			return value;
		} // end getValue

		private void setValue(V newValue) {
			value = newValue;
		} // end setValue

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end UnsortedLinkedDictionary
