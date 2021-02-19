This project 3 emulates the activation record of AR objects with the implementation of Parser’s Obj methods:
<assignment list> --> <assignment> | <assignment> <assignment list>
<assignment> --> <id> = <E> ";"
<E> --> <term> | <term> + <E> | <term> - <E>
<term> --> <primary> | <primary> * <term> | <primary> / <term>
<primary> --> <id> | <int> | <float> | <floatE> | "(" <E> ")" (USES CASES)
The course website provided an example of such with the reimplementation of assignmentList() (ARassignmentList). 
Printing to console and writing to file meet these criteria:
* the total number of function calls made so far
* the maximum stack size so far, measured by the number of activation records in the stack
* the ARs of the runtime stack displayed from top to bottom
A very similar procedure was taken with the non-Eval AR object classes. ParserStack and InterpreterStack were modified to match the classic classes as asked.
With the help of the helper class, RuntimeStack.java, which contains a universally used data structure (ArrayList<AR> rts), pushes and pops AR objects when an ARassignmentList object is called, pushed, and popped in InterpreterStack’s main. Structurally the non-Eval classes are near-identical to the Obj functions in Parser, as they should be, with some very subtle differences, like the breaks in ARprimary and the addition of getToken() in all non-Eval AR classes.
Conditionals in these classes check the next state, i.e  <primary> * <term> | <primary> / <term>, translates to if(LexArithArray.state == LexArithArray.State.Times) and if(LexArithArray.state == LexArithArray.State.Div).
A stringbuilder sb and function named consolePrint(), which appends the contents of rts onto the stringbuilder sb for easy printing to console and writing to argv[2]. A supplementary function, argvPrint, achieves this for us. 
RuntimeStack was of much help. 
The Eval classes add Eval AR class to the stack, which is subsequently printed from main. The implementation might not be 100%, however.