// the class of activation records of Eval() function for <primary>

class AREvalPrimary extends AR {

	@SuppressWarnings("unlikely-arg-type")
	public static void ADDARprimary() {

		AREvalPrimary arEvalP = new AREvalPrimary();

		for (AR ar : RuntimeStack.rtsREDUX) {

			if (ar.toString() == "ARprimary") {
				
				int check = RuntimeStack.rtsREDUX.indexOf(ar);

				RuntimeStack.rtsREDUX.set(check, arEvalP);

			}

		}

	}
}
