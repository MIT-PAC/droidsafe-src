package droidsafe.speclang;

import java.util.Set;

import soot.Type;
import droidsafe.utils.SootUtils;

public class TypeValue extends ArgumentValue {
    
	/**
	 * Create a new class type with the argument as the underlying class.
	 */
	public TypeValue(String value) {
		super(SootUtils.toSootType(value));
	}
	
	public TypeValue(Type type) {
		super(type);
	}
	

	public String toString() {
		return this.getType().toString();
	}
}
