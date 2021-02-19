
// the class of activation records of assignment() function

class ARassignment extends AR {

	// <assignment> --> <id> = <E> ";"

	// it is structurally identical to Parser's assignmentList

	// used picasso's reimplementation of assignmentlist as guidance

	// x is targetType and the return type is returnType.
	E e;

	Assignment returnVal;

	void assignment() {

		/*
		 * ARf ar = new ARf(); ar.target = value of target variable x;
		 * RuntimeStack.push(ar); ar.f(); returnType a = ar.returnVal;
		 * RuntimeStack.pop();
		 */

		if (LexArithArray.state == LexArithArray.State.Id) {

			String id = LexArithArray.t;

			LexArithArray.getToken();

			// in the case the state is an assignment, push to the data structure

			if (LexArithArray.state == LexArithArray.State.Assign) {
				LexArithArray.getToken();

				ARE arE = new ARE();

				RuntimeStack.push(arE);

				arE.E();

				e = arE.returnVal;

				RuntimeStack.pop();

				// in the case the state is a Semicolon, make an assignment
				if (LexArithArray.state == LexArithArray.State.Semicolon) {
					LexArithArray.getToken();

					returnVal = new Assignment(id, e);

					// error messages don't differ from the parser's assignment
				} else {

					Parser.errorMsg(4);
				}
			} else {

				Parser.errorMsg(3);
			}
		} else {
			Parser.errorMsg(5);

			returnVal = null;
		}

	}

}
