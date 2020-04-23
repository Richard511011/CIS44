
public class LabThreeTester {
public static void main(String[ ] args) {
	
	QueueInterface<Integer> first = new ArrayQueue<Integer>();
	QueueInterface<Integer> second = new ArrayQueue<Integer>();
	
		for(int i =0;i<25;i++) {
			first.enqueue(i);
		}
		for(int i =0;i<51;i++) {
			second.enqueue(i);
		}
		System.out.println("Test for check()\nfor \"abcab\" method returns "+((ArrayQueue<Integer>) first).check("abcab"));
		System.out.println("for \"rattan\" method returns "+((ArrayQueue<Integer>) first).check("rattan"));
		System.out.println("for \"booboo\" method returns "+((ArrayQueue<Integer>) first).check("booboo"));

		System.out.println("Test for splice()\na queue with integers 0-24 with a queue with integers 0-49, the original queue with values 0-24 becomes");
		((ArrayQueue<Integer>) first).splice(second);
		for(int i =0;i<=50;i++) {
			System.out.print(first.dequeue()+" ");
			
		}
		System.out.println();
		


    		
    	}
		
	
	
}

