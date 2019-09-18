
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");

			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){
		// TO-DO
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		switch(scenario){	
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			res = -1;
			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We get the first element of MyList
			int e0 = m.getElement(0);

			//2. We remove the first element from MyList we just checked
			m.removeElement(0);

			//3. We recursively solve the smaller problem
			res = maxInt(m);

			//4. We compute the final result, based on the value that we were hosting.
			//res = e0 + res; 
			if (e0 > res) 
				res = e0;

			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);

			break;
		}
		return res;


	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
		// TO-DO
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		boolean res = true;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() < 2) 
			scenario = 1;
		//Rule 3. MyList has more than 1 item
		else
			scenario = 2;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. MyList is empty
		case 1: 
			//1. List is empty
			res = true;
			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We get the first two elements of MyList
			int e0 = m.getElement(0);
			int e1 = m.getElement(1);

			//2. If the first one is smaller than the second, we keep testing the rest of MyList
			if (e0 >= e1){
				//2.1. We remove the first element from MyList
				m.removeElement(0);

				//2.2. We recursively solve the smaller problem
				res = isReverse(m);

				//2.3. We also add elem0 back to m1, so as to not to modify its original state
				m.addElement(0, e0);
			}
			//3. If the first one is bigger than the second one, we can conclude MyList is not sorted
			else
				res = false;

			break;
		}
		return res;


	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	

	public int getNumAppearances(MyList<Integer> m, int n){
		// TO-DO
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		//else if (m.length() == 1)
		//	scenario = 2;
		//Rule 3. MyList has more than 1 items
		else
			scenario = 2;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		switch(scenario){	
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message

			break;

			//Rule 2. MyList is non-empty
			//case 2: 
			//1. We get the first element of MyList
			//int e0 = m.getElement(0);

			//2. We remove the first element from MyList we just checked
			//m.removeElement(0);
			//if (n == e0)
			//res++;
			//break;
		case 2:
			//1. We get the first two elements of MyList
			int e1 = m.getElement(0);
			//2. If the first one is smaller than the second, we keep testing the rest of MyList			

			//2.1. We remove the first element from MyList
			m.removeElement(0);

			//2.2. We recursively solve the smaller problem
			res = getNumAppearances(m, n);


			if (n == e1)
				res++;
			//2.3. We also add elem0 back to m1, so as to not to modify its original state
			m.addElement(0, e1);


			//3. If the first one is bigger than the second one, we can conclude MyList is not sorted


			break;
		}
		return res;


	}

	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
		// TO-DO
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. Base number is 0
		if (n == 0) 
			scenario = 1;
		//Rule 2. power of n is 0
		else if (m == 0)
			scenario = 2;
		//Rule 3. power of n is 1
		else if (m == 1)
			scenario = 3;
		//Rule 4. power of n is more than 1
		else
			scenario = 4;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Base number is 0
		case 1: 
			break;

			//Rule 2. power of n is 0
		case 2: 
			//1. We get the first two elements of MyList
			res = 1;
			break;

			//Rule 3. power of n is 1
		case 3:
			res = n;
			break;


		case 4:
			//2.2. We recursively solve the smaller problem
			res = n * power(n, m -1);
			break;
		}
		return res;


	}

	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		// TO-DO

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. We look for the index 0 
		if (n == 0)
			scenario = 1;
		else if (n == 1)
			scenario = 2;
		else
			scenario = 3;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. We look for the index 0 
		case 1: 
			//1. We assign res to 2
			res = 2;

			break;

			//Rule 2. res is 1
		case 2:
			res = 1;

			break;

			//Rule 2. We look for an index bigger than 1
		case 3: 
			//1. We recursively solve the the smaller problem of computing n-1
			int res1 = lucas(n-1);

			//2. We recursively solve the the smaller problem of computing n-2
			int res2 = lucas(n-2);

			//3. We compute the final result 
			res = res1 + res2;

			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
		// TO-DO
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. We look for the index 0 
		if (n == 0)
			scenario = 1;
		else
			scenario = 2;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. We look for the index 0 
		case 1: 
			break;

			//Rule 2. n is bigger than 1
		case 2:
			res = 1;

			break;

			//Rule 2. We look for an index bigger than 1

		}		
	}

}
