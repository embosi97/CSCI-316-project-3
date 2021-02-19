import java.io.IOException;
import java.util.*;

public abstract class InterpreterStack extends ParserStack {

	public static HashMap<String, Val> varState = new HashMap<String, Val>();
	// program state, i.e., virtual memory for variables

	public static void main(String argv[]) {
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree
		// argv[2]: output file displaying runtime stack data
		// The interpretation result will be displayed on the terminal.

		setIO(argv[0], argv[1]);

		setLex();

		getToken();

		// commented out this part from interpreter

//		AssignmentList assignmentList = assignmentList(); // build a parse tree
//		if (!t.isEmpty())
//			displayln(t + " : Syntax Error, unexpected symbol where id expected");
//		else if (!errorFound) {
//			assignmentList.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file
//			assignmentList.M(varState); // interpret the assignment list
//			System.out.println(varState.toString()); // print the program state on the terminal
//		}
		// System.out.println(Interpreter.varState.toString());

		ARassignmentList AR = new ARassignmentList();

		RuntimeStack.push(AR);

		AR.assignmentList();

		RuntimeStack.pop();

		// for the eval elements
		AREvalE.ADDAREvalE();
		AREvalPrimary.ADDARprimary();

		RuntimeStack.consoleEvalPrint(RuntimeStack.rtsREDUX);

		ARMassignmentList.ADDARma();

		RuntimeStack.consoleEvalPrint(RuntimeStack.rtsREDUX);

		try {
			RuntimeStack.argvPrint(RuntimeStack.sb, argv[2]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeIO();

	}
}