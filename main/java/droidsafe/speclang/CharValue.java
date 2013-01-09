package droidsafe.speclang;

import soot.CharType;

public class CharValue extends ConcreteArgumentValue {
	private char value;
	
	public CharValue(char value) {
		super(CharType.v());
		this.value = value;
	}

	@Override
	public String toStringValue() {
		return "CHAR: " + value;
	}

	public char getValue() {
		return value;
	}

	/**
	 * If the value needs some delimiting or escaping, print here.
	 */
	public String toString() {
		return "\'" + value + "\'";
	}
	
	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		CharValue other = (CharValue) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
