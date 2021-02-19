
// the class of activation records of term() function

class ARterm extends AR {

	// <term> --> <primary> | <primary> * <term> | <primary> / <term>

	Primary primary;

	Term term;

	Term returnVal;

	void term() {

		ARprimary arPrim = new ARprimary();

		RuntimeStack.push(arPrim);

		arPrim.primary();

		primary = arPrim.returnVal;

		RuntimeStack.pop();

		if (LexArithArray.state == LexArithArray.State.Times) {
			LexArithArray.getToken();

			ARterm arTerm = new ARterm();

			RuntimeStack.push(arTerm);

			arTerm.term();

			term = arTerm.returnVal;

			RuntimeStack.pop();

			returnVal = new MulTerm(primary, term);

		} else if (LexArithArray.state == LexArithArray.State.Div)

		{
			LexArithArray.getToken();

			ARterm arTerm = new ARterm();

			RuntimeStack.push(arTerm);

			arTerm.term();

			term = arTerm.returnVal;

			RuntimeStack.pop();

			returnVal = new DivTerm(primary, term);

		} else

			returnVal = new SinglePrimary(primary);
	}

}