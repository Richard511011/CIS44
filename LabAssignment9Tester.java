
public class LabAssignment9Tester {
	public static void main(String[] args) {
		// testCountMethods();
		testIslomorphic();
	}
		//Tester fir problem 1 count1() and count2()
	public static void testCountMethods() {
		BinaryTree<Integer> l1 = new BinaryTree(1);
		BinaryTree<Integer> l2 = new BinaryTree(2);
		BinaryTree<Integer> l3 = new BinaryTree(3, l1, l2);
		BinaryTree<Integer> leftSub = new BinaryTree(5, l1, l2); // subtree with 5 as root, 1,2 as subtrees
		BinaryTree<Integer> rightSub = new BinaryTree(7, l2, l3); // tree with 7 as root, 2 as left subtree, 3,1,2 as
																	// right subtree
		BinaryTree<Integer> root = new BinaryTree(5, leftSub, rightSub);// tree with 5 as root, 5,1,2 on left subtree,
																		// 7,2,3,1,2 on right subtree
		BinaryTree<Integer> emptyTree = new BinaryTree();
		System.out.println("Testing with count1 tree with elements 1,1,2,2,2,3,5,5,7");
		System.out.println("count1(1) returns " + root.count1(1));
		System.out.println("count1(2) returns " + root.count1(2));
		System.out.println("count1(5) returns " + root.count1(5));
		System.out.println("count1(7) returns " + root.count1(7));
		System.out.println("count1(100), a value not in the tree returns " + root.count1(100));
		System.out.println("count1(10) on an empty tree returns " + emptyTree.count1(100));
		System.out.println();
		System.out.println("Testing with count2 tree with elements 1,1,2,2,2,3,5,5,7");
		System.out.println("count2(1) returns " + root.count2(1));
		System.out.println("count2(2) returns " + root.count2(2));
		System.out.println("count2(5) returns " + root.count2(5));
		System.out.println("count2(7) returns " + root.count2(7));
		System.out.println("count2(100), a value not in the tree returns " + root.count2(100));
		System.out.println("count1(10) on an empty tree returns " + emptyTree.count1(100));
	}
	
	//Tester for problem 2 islomorphic()
	public static void testIslomorphic() {
		BinaryTree<Integer> l1 = new BinaryTree(1);
		BinaryTree<Integer> l2 = new BinaryTree(2);
		BinaryTree<Integer> l4 = new BinaryTree(100);
		BinaryTree<Integer> l3 = new BinaryTree(3, l1, l2);
		BinaryTree<Integer> leftSub1 = new BinaryTree(6,l1,l4);
		BinaryTree<Integer> rightSub1 = new BinaryTree(94,l4,l3);
		BinaryTree<Integer> leftSub = new BinaryTree(5, l1, l2); // subtree with 5 as root, 1,2 as subtrees
		BinaryTree<Integer> rightSub = new BinaryTree(7, l2, l3); // tree with 7 as root, 2 as left subtree, 3,1,2 as
																	// right subtree
		BinaryTree<Integer> treeOne = new BinaryTree(5, leftSub, rightSub);// tree with 5 as root, 5,1,2 on left subtree,
																		// 7,2,3,1,2 on right subtree
		BinaryTree<Integer> treeTwo = new BinaryTree(5, leftSub, rightSub); // Identical copy of tree1
		
		BinaryTree<Integer> treeThree = new BinaryTree(10,treeTwo,l1); // new tree
		BinaryTree<Integer> treeFour = new BinaryTree(100,leftSub1,rightSub1);
		BinaryTree<Integer> emptyTree1 = new BinaryTree();
		BinaryTree<Integer> emptyTree2 = new BinaryTree();
		System.out.println("Testing islomorphic()");
		System.out.println("with two trees that are identical Islomorphic() returns "+ treeOne.islomorphic(treeTwo));
		System.out.println("with two trees that are structurally the same but contain different values Islomorphic() returns "+ treeTwo.islomorphic(treeFour));
		System.out.println();
		System.out.println("with two trees that are empty, Islomorphic() returns "+emptyTree1.islomorphic(emptyTree2));
		

		
		
	}
}
