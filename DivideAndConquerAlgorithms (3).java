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
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 	
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList has 1 elements
		else if (m.length() == 1)
			scenario = 2;
		//Rule 3. MyList has more than 1 elements
		else
			scenario = 3;		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. MyList is empty 
		case 1: 
			//1. We assign res to 0
			System.out.println("Empty MyList");

			break;

			//Rule 2. MyList has 1 element	
		case 2:
			//1. We get the first element of MyList
			int e = m.getElement(0);

			//4. We compute the final result, based on the value that we were hosting.
			System.out.println(e); 

			break;

			//Rule 3. MyList has more than 1 elements
		case 3: 
			//1. We get the first element of MyList
			int e0 = m.getElement(0);

			//4. We compute the final result, based on the value that we were hosting.
			System.out.println(e0); 

			//2. We remove the first element from MyList we just checked
			m.removeElement(0);

			//3. We recursively solve the smaller problem
			recursiveDisplayElements(m);


			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e0);

			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		

	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

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
		//Rule 2. MyList has 1 elements
		else if (m.length() == 1)
			scenario = 2;
		//Rule 3. MyList has more than 1 elements
		else
			scenario = 3;	
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. MyList is empty 
		case 1: 
			//1. We assign res to 0
			res = new MyDynamicList<Integer>();

			break;

			//Rule 2. MyList has 1 element	
		case 2:
			//1. We get the first element of MyList
			int e0 = m.getElement(0);
			res = new MyDynamicList<Integer>();
			if (e0 < e) {
				res.addElement(0, e0);
				System.out.println(e0);
			}
			//4. We compute the final result, based on the value that we were hosting.


			break;

			//Rule 3. MyList has more than 1 elements
		case 3: 
			//1. We get the first element of MyList
			int e1 = m.getElement(0);

			//2. We remove the first element from MyList we just checked
			m.removeElement(0);

			//3. We recursively solve the smaller problem
			res = smallerMyList(m , e);
			if (e1 < e) {
				res.addElement(0, e1);
				System.out.println(e1);
			}
			//4. We add back e0 to the resulting list.


			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e1);

			break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

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
		//Rule 2. MyList has 1 elements
		else if (m.length() == 1)
			scenario = 2;
		//Rule 3. MyList has more than 1 elements
		else
			scenario = 3;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. MyList is empty 
		case 1: 
			//1. We assign res to 0
			res = new MyDynamicList<Integer>();

			break;

			//Rule 2. MyList has 1 element	
		case 2:
			//1. We get the first element of MyList
			int e0 = m.getElement(0);
			res = new MyDynamicList<Integer>();
			if (e0 >= e) {
				res.addElement(0, e0);
			}
			//4. We compute the final result, based on the value that we were hosting.


			break;

			//Rule 3. MyList has more than 1 elements
		case 3: 
			//1. We get the first element of MyList
			int e1 = m.getElement(0);

			//2. We remove the first element from MyList we just checked
			m.removeElement(0);

			//3. We recursively solve the smaller problem
			res = biggerEqualMyList(m , e);
			if (e1 >= e) {
				res.addElement(0, e1);
			}
			//4. We add back e0 to the resulting list.


			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, e1);

			break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 		
		//Rule 1. MyList m1 is empty
		if (m1.length() == 0) 
			scenario = 1;
			//Rule 2. MyList m2 is empty
		else if (m2.length() == 0) 
				scenario = 2;
			else 
				scenario = 3;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		int e0 = 0;
			
		switch(scenario){	
				
		//Rule 1. MyList m1 is empty
		case 1: 
			//1. We create the new list as a result
			res = new MyDynamicList<Integer>();
			
			res = m2;
			
			break;
		
		//Rule 2. MyList m2 is empty
		case 2: 
			//1. We create the new list as a result
			res = new MyDynamicList<Integer>();
			
			res = m1;
			
			break;

		//Rule 3. m1 first element smaller or equal than m2 first element
		case 3: 
			//1. We get the first element of m1
			e0 = m1.getElement(0);
			
			//2. We remove the first element from m1 we just checked
			m1.removeElement(0);
			
			//3. We recursively solve the smaller problem
			res = concatenate(m1, m2);
			
			//4. We add back e0 to the resulting list.
			res.addElement(0, e0);
			
			//5. We also add the element back to m1, so as to not to modify its original state
			m1.addElement(0, e0);

			break;			
						
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		MyList<Integer> s1 = null;
		MyList<Integer> b1 = null;
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList m1 is empty
		if (m.length() == 0) 
			scenario = 1;
		else if (m.length() == 1)
			scenario = 2;	
		else
			scenario = 3;
			
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		int e0 = 0;
		int e1 = 0;
		res = new MyDynamicList<Integer>();
		MyList<Integer> res1;
		MyList<Integer> res2;
		switch(scenario){	
				
		//Rule 1. MyList m is empty
		case 1: 
			
			
			break;
		
		//Rule 2. m has 1 element
		case 2: 
			
			e0 = m.getElement(0);
			res.addElement(0, e0);
			break;
			
		//Rule 3. m has more than 1 element
		case 3:
			//Get x from M
			e0 = m.getElement(0);
			//Remove x from M
			m.removeElement(0);
			//Smaller x in M'
			s1 = smallerMyList(m, e0);
			
			//Bigger than x in M'
			b1 = biggerEqualMyList(m, e0);
			//Quick sort S1
			res1 = quickSort(s1);
			//Quick sort B1
			res2 = quickSort(b1);
			//Add x to Res2
			res2.addElement(0, e0);
			//Concatenate res1 and res 2 to res
			res = concatenate(res1,res2);
			//Put x back to M'
			m.addElement(0, e0);
			break;
		}		

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}		

}
