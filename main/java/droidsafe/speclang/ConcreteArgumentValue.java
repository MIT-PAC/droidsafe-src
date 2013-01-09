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
	protected Type type;
	
	public ConcreteArgumentValue(Type type) {
		this.type = type;
	}

	public abstract String toStringValue();
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConcreteArgumentValue other = (ConcreteArgumentValue) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
