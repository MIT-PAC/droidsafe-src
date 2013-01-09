package droidsafe.speclang;

import soot.BooleanType;

public class BooleanValue extends ConcreteArgumentValue {
	private boolean value;
	
	public static BooleanValue TRUE = new BooleanValue(true);
	public static BooleanValue FALSE = new BooleanValue(false);
	
	private BooleanValue(boolean value) {
		super(BooleanType.v());
		this.value = value;
	}

	@Override
	public String toStringValue() {
		return "BOOLEAN: " + value;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String toString() {
		return value + "";
	}
}
