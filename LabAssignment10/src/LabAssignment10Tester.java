
public class LabAssignment10Tester {
	//Professor skipped lecture for this lab 4/26/2020
	public static void main(String[] args) {
		isBalancedTester();
		getPredecessorTester();
		getKthSmallestTester();
	}
	//Tester for isBalanced
	public static void isBalancedTester() {
		System.out.println("Testing for isBalancedTester());
		BinarySearchTree<Integer> l1 = new BinarySearchTree(10);
		BinarySearchTree<Integer> empty = new BinarySearchTree();
		l1.add(5);
		l1.add(15);
		System.out.println("Calling isBalanced() on a balanced tree with subtrees of same height returns "+l1.isBalaced());
		l1.add(3);
		System.out.println("Calling isBalanced() on a balanced tree with subtrees that differ in height by one returns "+l1.isBalaced());
		l1.add(4);
		l1.add(16);
		l1.add(17);
		System.out.println("Calling isBalanced() on a non balanced tree with subtrees of equal height returns " +l1.isBalaced());
		BinarySearchTree<Integer> emptyTree = new BinarySearchTree();
		System.out.println("Calling isBalanced() on a empty tree returns "+empty.isBalaced());
	}
	public static void getPredecessorTester() {
		System.out.println("Testing for getPredecessor");
	}
	public static void getKthSmallestTester() {
		
	}
}
