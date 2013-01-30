package droidsafe.speclang;

import soot.Type;

/** 
 * Superclass for argument values that are concrete such as booleans, ints, chars, and strings.
 * To be placed in lists of concrete values.
 * 
 * @author mgordon
 *
 */
public abstract class ConcreteArgumentValue {
	
	public abstract String toStringValue();
	
}
