package droidsafe.speclang;

import soot.RefType;

public class ClassValue  extends ConcreteArgumentValue {

	private String value;

	public ClassValue(String value) {
		super(RefType.v("java.lang.Class"));
		this.value = value;
	}

	@Override
	public String toStringValue() {
		return "CLASS: " + value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return "*" + value;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ClassValue other = (ClassValue) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
	

}
