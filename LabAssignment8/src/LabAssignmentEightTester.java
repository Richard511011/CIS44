
public class LabAssignmentEightTester {
	public static void main(String[] args) {
			UnsortedLinkedDictionary<String,Integer> ageList = new UnsortedLinkedDictionary<String,Integer>();
			System.out.println("Testing UnsortedLinkedDictionary, ageList is declared with Strings of names as keys and Integers of ages as values");
			//Test for add() getValue() and size()
			System.out.println();
			System.out.println("Test for add() getValue() and size()");
			ageList.add("Jim", 21);
			ageList.add("Tim", 23);
			ageList.add("Sarah", 22);
			//
			System.out.println("Sarah's age is "+ageList.getValue("Sarah")+" dictionary size is "+ageList.getSize());
			ageList.add("Sarah", 67);
			System.out.println("After adding another key Sarah with value 67, Sarah's age is now "+ageList.getValue("Sarah")+" dictionary size is "+ageList.getSize());
			System.out.println();
			//Test for remove() 
			System.out.println("Test for remove()");
			ageList.remove("Jim");
			ageList.remove("Tim");
			ageList.remove("Sarah");
			System.out.println("After removing all 3 entries, length of dictionary is now "+ageList.getSize());
			System.out.println("Calling remove() with a nonexistent key returns "+ageList.remove("Jim"));
			System.out.println();
			//Test for isEmpty() and Clear()
			System.out.println("Test for isEmpty() and Clear()");
			ageList.add("Natasha", 39);
			ageList.add("Clint", 45);
			ageList.add("Thor", 54);
			ageList.add("Bruce",32);
			ageList.add("Tony",56);
			System.out.println("With a dictionary length of "+ageList.getSize()+" isEmpty() returns "+ageList.isEmpty());
			ageList.clear();
			System.out.println("After clear() is called, the length of dictionary is "+ageList.getSize()+" isEmpty() returns "+ageList.isEmpty());
			//Test for contains
			System.out.println();
			System.out.println("Test for contains");
			ageList.add("Thor",56);
			System.out.println("Calling contains() with a key in the dictionary returns "+ageList.contains("Thor"));
			System.out.println("Calling contains() with a key not in the dictionary returns "+ageList.contains("Odin"));
			ageList.clear();
			System.out.println("Calling contains() with an empty dictionary returns "+ageList.contains("Thor"));
			
			
			
	}
}
