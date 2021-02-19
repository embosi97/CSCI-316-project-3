// the class of activation records of assignmentList() function

class ARassignmentList extends AR {

	// reimplementation of Parser.assignmentList():
	// it is structurally identical to Parser's assignmentList
	Assignment assignment;
	AssignmentList assignmentList;
	AssignmentList returnVal;

	void assignmentList()

	// <assignment list> --> <assignment> | <assignment> <assignment list>

	{
		ARassignment ar = new ARassignment();
		
		RuntimeStack.push(ar);
		ar.assignment();
		assignment = ar.returnVal;
		RuntimeStack.pop();

		if (LexArithArray.state == LexArithArray.State.Id) {
			ARassignmentList ar_ = new ARassignmentList();
			RuntimeStack.push(ar_);
			ar_.assignmentList();
			assignmentList = ar_.returnVal;
			RuntimeStack.pop();

			returnVal = new MultipleAssignment(assignment, assignmentList);
		} else
			returnVal = assignment;
	}

}