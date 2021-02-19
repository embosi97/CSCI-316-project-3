
// the class of activation records of M() function for <assignmentList>

class ARMassignmentList extends AR {

	@SuppressWarnings("unlikely-arg-type")
	public static void ADDARma() {

		ARMassignmentList arEvalM = new ARMassignmentList();

		for (AR ar : RuntimeStack.rtsREDUX) {

			if (ar.toString() == "ARassignmentList" || ar.toString() == "ARassignment") {
				
				int check = RuntimeStack.rtsREDUX.indexOf(ar);

				RuntimeStack.rtsREDUX.set(check, arEvalM);

			}

		}

	}
}