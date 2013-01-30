package droidsafe.utils;

import soot.SootClass;
import soot.SootMethod;

public class CannotFindMethodException extends Exception {
	public CannotFindMethodException(SootClass clz, SootMethod method) {
		super(String.format("Cannot find or resolve %s in %s.", method, clz));
	}
}
