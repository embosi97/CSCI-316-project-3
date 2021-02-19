import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RuntimeStack {

	// this makes the printing near-identical to picasso's output

	// data structure of choice was an arraylist
	static ArrayList<AR> rts = new ArrayList<AR>();
	static ArrayList<AR> rtsREDUX = new ArrayList<AR>();

	// using a stringbuilder to write to the console and print to argv[2]
	static StringBuilder sb = new StringBuilder();

	// function i'll use to print to the console
	public static void consolePrint() {

		if (rtsREDUX.size() != 0) {

			rtsREDUX.clear();
		}

		sb.append("-----------------------------------------------------------" + "" + "\n"
				+ "The total number of function calls so far = " + AR.calls.get() + "\n"
				+ "The maximum stack size so far = " + rts.size() + "\n" + "\n"
				+ "The ARs of the runtime stack will be displayed from top to bottom:" + "\n" + "\n");

		ArrayList<AR> arCopy = new ArrayList<AR>(rts);

		// must reverse it since primary is usually the last on the stack
		Collections.reverse(arCopy);

		for (AR ar : arCopy) {

			sb.append(AR.as.getAndIncrement() + ": " + ar + "\n");
			rtsREDUX.add(ar);

		}

		arCopy.clear();

		AR.as.set(1);
	}

	// writing the stringbuilder to a file and printing it to console
	public static void argvPrint(StringBuilder strb, String argv) throws IOException {

		File file = new File(argv);

		BufferedWriter buff = new BufferedWriter(new FileWriter(file));

		buff.write(strb.toString());

		System.out.print(strb);

		buff.close();

	}

	// for printing the eval added classes
	public static void consoleEvalPrint(ArrayList<AR> arr) {

		AR.calls.set(AR.calls.intValue() + (arr.size() - 1));

		sb.append("-----------------------------------------------------------" + "" + "\n"
				+ "The total number of function calls so far = " + AR.calls.get() + "\n"
				+ "The maximum stack size so far = " + arr.size() + "\n" + "\n"
				+ "The ARs of the runtime stack will be displayed from top to bottom:" + "\n" + "\n");

		for (AR ar : arr) {

			sb.append(AR.as.getAndIncrement() + ": " + ar + "\n");

		}

		AR.as.set(1);
	}

	// adding a push function for my arraylist
	public static void push(AR ar) {

		AR.calls.getAndIncrement();

		rts.add(ar);
	}

	static void pop() {

		rts.remove(rts.size() - 1);
		// System.out.print("Size of the stack is " + rts.size() + "\n");

	}

}