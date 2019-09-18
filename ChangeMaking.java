/**
 * Classical Change making problem with an unlimited amount of coins of each type. <br> 
 * Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
 * Depending on the type of coins, it can lead to an optimal solution.<br>
 * The class encapsulates all the functions of the Greedy schema<br>
 */

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}


	// -------------------------------------------------------------------
	// 1. selectionFunctionFirstCandidate--> It selects the first candidate 
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionFirstCandidate(MyList<Integer> candidates) {

		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'items'.
		int size = candidates.length();

		//We use 'index' to state the index of the candidate being checked.
		int index = 0;

		//OP1. We traverse all elements in items, so as to find the first one not being picked so far. 
		while ((res == -1) && (index < size)){
			//OP1.1. If the item has not been picked before, we pick it
			if (candidates.getElement(index) == 0){
				res = index;

			}

			//OP1.2. We increase 'index' so as to try the next item
			index++;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}


	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the best coin according to the objective function of minimizing the number
	 * of coins that make the change of the amount. 
	 * @param candidates: List of candidates
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBestCandidate( MyList<Integer> candidates ){

		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'minWeight' to keep track of the best weight found so far. 
		//We use 'index' to compute just once the length of MyList 'items'.
		int minWeight = Integer.MAX_VALUE;
		int index = candidates.length() - 1;

		//OP1. We traverse all items of MyList, to find the 'index' of the item with minimal weight
		while (index >= 0){
			//OP1.1. Auxiliary variables: 
			//We use 'e0' to compute the first item of 'items' just once.
			int e0 = candidates.getElement(index);

			//OP1.1. If a not previously considered item improves minWeight, we update 'res' and 'minWeight'
			if ((candidates.getElement(index) == 0) && (e0 < minWeight)){
				res = index;
				minWeight = e0;
			}

			//OP1.2. We decrease 'index' so as to try the previous item of 'items'
			index--;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated){

		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = false;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. We check if the candidate fits or not
		if (candidateValue + changeGenerated <= amount)
			res = true;

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	// -------------------------------------------------------------------
	// 5. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {

		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'itemsConsidered'.
		int size = candidates.length();

		//We use 'index' to state the index of the candidate being checked.
		int index = 0;

		//OP1. We traverse all elements in items, so as to check if one not being selected so far can be added to the knapsack. 
		while ((res == true) && (index < size)){
			//OP1.1. If the item has not been considered before
			if (candidates.getElement(index) == 0){
				res = false;
			}

			//OP1.2. We increase 'index' so as to try the next item
			index++;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its objective function value according to:<br>
	 * How many coins are used in the solution.<br>
	 * @param sol: The MyList containing the solution to the problem. 
	 * @return: The objective function value of such solution.
	 */	
	public int  objectiveFunction(MyList<Integer> sol){

		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'sol'.
		int size = sol.length() - 1;

		//OP1. We traverse all the items of the list
		while (size >= 0){
			//OP1.1. We add +1 for each item taken in the solution 		
			res = res + sol.getElement(size);

			//OP1.2. We decrease 'size' so as to try the previous item of 'sol'
			size--;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){
		//TO-DO

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		int solutionValue = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//OP1. Auxiliary variables:
		//We use 'size' to compute just once the length of MyList 'items'.
		int size = coinValues.length();

		//We use 'itemsConsidered' as a MyList with the items being considered by selectionFunction so far.
		MyList<Integer> itemsConsidered = null;

		//We use 'capacityUsed' to state the amount of weight our bin contains so far.
		int capacityUsed = 0;			

		//OP1. We initialise all variables: 

		//OP1.1. 'res' is initialised to be a list of the size of items, with all values being 0.
		res = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			res.addElement(0, 0);

		//OP1.2. 'itemsConsidered' is initialised to be a list of the size of items, with all values being 0.
		itemsConsidered = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			itemsConsidered.addElement(0, 0);

		//OP2. We construct the final solution:
		while (solutionTest(itemsConsidered) == false){
			//OP2.1 Auxiliary variables:
			//We use 'itemSelected' to state the index of the candidate being selected.
			int itemSelected = -1;

			//OP2.1. We pick the most promising candidate
			itemSelected = selectionFunctionBestCandidate(itemsConsidered);

			//OP2.2. If the candidate is feasible
			if (feasibilityTest(itemSelected, amount, capacityUsed) == true){
				//OP2.2.1. We add it to the solution
				res.removeElement(itemSelected);
				res.addElement(itemSelected, 1);

				//OP2.2.2. We update the capacity used in the bin
				capacityUsed = capacityUsed + coinValues.getElement(itemSelected);
			}

			//OP2.3. We discard the candidate for future iterations
			itemsConsidered.removeElement(itemSelected);
			itemsConsidered.addElement(itemSelected, 1);			
		}

		solutionValue = objectiveFunction(res);
		System.out.println("Solution = " + solutionValue + " items placed in the bin");

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		


	}

}
