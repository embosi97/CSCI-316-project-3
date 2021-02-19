
// the class of activation records of E() function

class ARE extends AR {
	
	// <E> --> <term> | <term> + <E> | <term> - <E>

	
	E e;
	
	Term term;
	
	E returnVal;

	void E() {

		/*
		 * class ARf extends AR { 
		 * targetType target; 
		 * field for local variable 1; ...
		 * field for local variable m;
		 *  returnType returnVal;
		 * 
		 * void f() { ... here reimplement body code of f() ...
		 *  }
		 *   }
		 * 
		 * 
		 */

		ARterm arTerm = new ARterm();
		
		RuntimeStack.push(arTerm);
		
		arTerm.term();
		
		term = arTerm.returnVal;
		
		RuntimeStack.pop();

		if (LexArithArray.state == LexArithArray.State.Plus) {
			
			LexArithArray.getToken();
			
			ARE arE = new ARE();
			
			RuntimeStack.push(arE);
			
			arE.E();
			
			e = arE.returnVal;
			
			RuntimeStack.pop();
			
			returnVal = new AddE(term, e);
			
		} else if (LexArithArray.state == LexArithArray.State.Minus) {
			
			LexArithArray.getToken();
			
			ARE arE = new ARE();
			
			RuntimeStack.push(arE);
			
			arE.E();
			
			e = arE.returnVal;
			
			RuntimeStack.pop();
			
			returnVal = new SubE(term, e);
			
		} else
			
			returnVal = new SingleTerm(term);
	}
}
