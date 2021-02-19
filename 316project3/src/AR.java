import java.util.concurrent.atomic.AtomicInteger;
// the class of activation records

/*
 * Create an abstract class AR whose objects will be activation records. 
 * Actual activation records for function calls will be objects of subclasses of AR. 
 */

abstract class AR {

	// some atomic integers for RuntimeStack
	static AtomicInteger calls = new AtomicInteger(0);
	static AtomicInteger as = new AtomicInteger(1);

	// toString for AR objects
	public String toString() {
		return this.getClass().getName();
	}
}