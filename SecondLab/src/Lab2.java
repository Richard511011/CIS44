class Lab2 {
	public static void main(String[] arg) {
		int[] a = {2, 3, 5, 7, 11, 13, 17, 19, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,  23, 29, 31, 37, 41, 43};
			System.out.println("Test for problem 4, answer is "+min(a,0,a.length-1));
			
			System.out.println("Test for computePay, answer is "+computePay(39));
			System.out.println("Test for computeSavings, answer is "+computeSavings(39));
			
			System.out.println("Test for countSubstring result is "+
			countSubstring("Java is a programming language originally developed by James Gosling at "
					+ "Sun Microsystems  and released in 1995 as a core component of Sun Microsystems "
					+ "Java platform. The language derives much of its syntax from C "
					+ "and C++ but has a simpler object model and fewer low-level facilities. "
					+ "Java applications are typically compiled to bytecode (class file) that can"
					+ " run on any Java Virtual Machine (JVM) regardless of computer architecture. "
					+ "Java is a general-purpose, concurrent, class-based, object-oriented language "
					+ "that is specifically designed to have as few implementation dependencies as possible. "
					+ "Java is currently one of the most popular programming languages in use, particularly"
					+ " for client-server web applications, with a reported 10 million users","Java"));
	}

	// Problem 1
	public static int min(int[] a,int b,int c) {
		int value1;
		int value2;
		int middle = (b+c)/2;
		if (b==c)
			return a[b];
		else {
			value1 = min(a,b,middle);
			value2 = min(a,middle+1,c);
		}
		if (value1<=value2)
			return value1;
			return value2;
	}

	

	// Problem 2
	public static long computePay(int day) {
		if (day == 1)
			return 1;

		return 2 * computePay(day - 1);
	}

	public static long computeSavings(int day) {
		if (day == 1)
			return computePay(day);
		else
			return (computePay(day) + computeSavings(day - 1));
	}

	// Problem 3
	public static int countSubstring(String s1, String s2) {
		if (s1.indexOf(s2) < 0)
			return 0;
		else

			return 1 + countSubstring(s1.substring(s1.indexOf(s2) + s2.length()), s2);

	}
}