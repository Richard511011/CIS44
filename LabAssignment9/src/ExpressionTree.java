	
public class ExpressionTree extends BinaryTree<String> {
    public ExpressionTree() {
    } // end default constructor
    
    public ExpressionTree(String data) {
		//super(data);
		root = formTree(data,0,(data.length()-1));
    } // end default constructor
    
    public double evaluate() {
		return evaluate(root);
    } // end evaluate
    
	private BinaryNode formTree(String expr,int first, int last) {
		if(first>last) {
			return null;
			
		}
			
		
		if (first==last)
			return new BinaryNode<String>(expr.substring(first, last+1));
		
		String root =expr.substring(first,first+1) ;
		int target = 0;
		
 		for(int i =first+1;i<=last;i++) {	//Retrieves the operator with the lowest precedent (or the root)
 			switch(expr.substring(i, i+1)){
 				case "+":
 					root = "+";
 					target = i;
 					break;
 				case "-":
 					root = "-";
 					target = i;
 					break;
 				case "*":
 					if(root.equals("+")||root.equals("-")) {
 						break;
 					}
 					root = "*";
 					target = i;
 					break;
 				case "/":
 					if(root.equals("+")||root.equals("-")) {
 						break;
 					}
 					root = "/";
 					target = i;
 					break;
 			}
 			
 				
 		}
 		BinaryNode<String> subtree = new BinaryNode<String>(root,formTree(expr,first,target-1),formTree(expr,target+1,last));
			return subtree;
 		
 	}
 	
    private double evaluate(BinaryNode<String> rootNode) {
		double result;
	
		if (rootNode == null)
			result = 0;
		else if (rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		} // end if

		return result;
    } // end evaluate
    
    private double getValueOf(String variable) { // strings allow multicharacter variables
	
		double result = 0;
	
		if (variable.equals("a"))
			result = 1;
		else if (variable.equals("b"))
			result = 2;
		else if (variable.equals("c"))
			result = 3;
		else if (variable.equals("d"))
			result = 4;
		else if (variable.equals("e"))
			result = 5;
	
		return result;
   } // end getValueOf

   private double compute(String operator, double firstOperand, double secondOperand)
   {
      double result = 0;
      
      if (operator.equals("+"))
	  	result = firstOperand + secondOperand;
      else if (operator.equals("-"))
	  	result = firstOperand - secondOperand;
      else if (operator.equals("*"))
	  	result = firstOperand * secondOperand;
      else if (operator.equals("/"))
	  	result = firstOperand / secondOperand; 
      return result;
   } // end compute

} // end ExpressionTree
