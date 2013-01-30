package droidsafe.speclang;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import soot.RefType;

public class StringValue extends ConcreteArgumentValue {
	private String value;

	public StringValue(String value) {
		super();
		this.value = value;
		escape();
	}

	@Override
	public String toStringValue() {
		return "STRING: " + value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		escape();
	}

	public String toString() {
		return "\"" + value + "\"";
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
		StringValue other = (StringValue) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
	
	
	public void escape() {
		 final StringBuilder result = new StringBuilder();
		 for (char character : value.toCharArray() ){
	       if (character == '"') {
	         result.append("\\\"");
	       } else result.append(character);
	     }
	     value = result.toString();
	}
}
