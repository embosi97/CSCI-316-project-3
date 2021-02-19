// the class of activation records of Eval() function for <E>

class AREvalE extends AR {
	@SuppressWarnings("unlikely-arg-type")
	public static void ADDAREvalE() {

		AREvalE arEvalE = new AREvalE();

		for (AR ar : RuntimeStack.rtsREDUX) {

			if (ar.toString() == "ARE") {
				
				int check = RuntimeStack.rtsREDUX.indexOf(ar);

				RuntimeStack.rtsREDUX.set(check, arEvalE);

			}

		}

	}
}