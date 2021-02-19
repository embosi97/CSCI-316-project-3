
// the class of activation records of primary() function

class ARprimary extends AR {

	// <primary> --> <id> | <int> | <float> | <floatE> | "(" <E> ")"

	E e;

	Primary returnVal;

	void primary() {

		// breaks were added so the following cases would not be visited

		//consolePrint happens here since ARprimary is the last on the stack
		//I know this because I first printed it bottom to top (without reversing it)
		RuntimeStack.consolePrint();

		switch (LexArithArray.state)

		{
		// this is heavily based from parser's primary()
		// cases are used in this case

		// in the case ids are involved

		case Id:

			Id id = new Id(LexArithArray.t);

			LexArithArray.getToken();

			returnVal = id;

			break;

		// in the case ints are involved

		case Int:

			Int intElem = new Int(Integer.parseInt(LexArithArray.t));

			LexArithArray.getToken();

			returnVal = intElem;

			break;

		// in the case floats are involved, either type

		case Float: case FloatE:

			Floatp floatElem = new Floatp(Float.parseFloat(LexArithArray.t));

			LexArithArray.getToken();

			returnVal = floatElem;

			break;

		// in the case left parentheses are used

		case LParen:

			LexArithArray.getToken();

			ARE arE = new ARE();

			RuntimeStack.push(arE);

			E e = arE.returnVal;

			RuntimeStack.pop();

			if (LexArithArray.state == LexArithArray.State.RParen) {
				LexArithArray.getToken();

				returnVal = new Parenthesized(e);
			} else {

				Parser.errorMsg(1);

				returnVal = null;
			}

			break;

		default:

			Parser.errorMsg(2);

			returnVal = null;

		}
	}

}