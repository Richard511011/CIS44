
public class LabAssignment10Tester {
	//Tester
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
	public static void isIBSTTester(){
		System.out.println("Tester for isIBST");
		BinarySearchTree<Integer> l1 = new BinarySearchTree(10);
		BinarySearchTree<Integer> empty = new BinarySearchTree(3);
		l1.add(5);
		l1.add(15);
		System.out.println("Calling isIBST() on a full BinarySearchTree returns "+l1.isBST());
		System.out.println("Calling isIBST() on a BinarySearchTree with just a root returns "+empty.isBST());
		l1.add(3);
		l1.add(2);
		l1.add(1);
		System.out.println("Calling isIBST() on a non balanced BinarySearchTree returns "+l1.isBST());
	}
	public static void getPredecessorTester() {
		System.out.println("Testing for getPredecessor");
	}
	public static void getKthSmallestTester() {
		
	}
}
