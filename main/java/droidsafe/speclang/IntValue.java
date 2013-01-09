package droidsafe.speclang;

import soot.IntType;

public class IntValue extends ConcreteArgumentValue {
	private int value;
	
	public IntValue(int value) {
		super(IntType.v());
		this.value = value;
	}

	@Override
	public String toStringValue() {
		return "INT: " + value;
	}

	public String toString() {
		return value + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		IntValue other = (IntValue) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
