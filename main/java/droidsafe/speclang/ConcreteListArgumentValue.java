package droidsafe.speclang;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.Utils;
import droidsafe.android.app.Project;

import soot.Type;
import soot.VoidType;


public class ConcreteListArgumentValue extends ArgumentValue  {
	private static final Logger logger = LoggerFactory.getLogger(ConcreteListArgumentValue.class);
	
	private LinkedList<ConcreteArgumentValue> args;
	
	public ConcreteListArgumentValue(Type type) {
		super(type);
		args = new LinkedList<ConcreteArgumentValue>();
	}

	public void add(ConcreteArgumentValue v) {
		if (!args.contains(v))
			args.add(v);
	}
	
	public void addAll(ConcreteListArgumentValue l) {
		for (ConcreteArgumentValue v : l.args) {
			this.add(v);
		}
	}
	
	public int size() {
		return args.size();
	}
	
	/**
	 * Does this concrete value list enable the given values? 
	 * Meaning check the give to make sure all values appear in this.
	 */
	public boolean doesEnable(ConcreteListArgumentValue testMe) {
		for (int i = 0; i < testMe.args.size(); i++) {
		
			if (!this.args.contains(testMe.args.get(i))) {
				return false;
			}
			
		}
		return true;
	}
	
	/**
	 * Combine two lists into a single list without duplicate values.
	 * 
	 * @param val1
	 * @param val2
	 * @return A new object with the combined list
	 */
	public static ConcreteListArgumentValue combine(ConcreteListArgumentValue val1,
			ConcreteListArgumentValue val2, Type actualType) {
		
		ConcreteListArgumentValue ret = new ConcreteListArgumentValue(actualType);
		
		ret.addAll(val1);
		ret.addAll(val2);
		
		return ret;
	}
	
	/**
	 * Set the type of all the underlying values.
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public String toString() {
		String ret = "";
		for (int i = 0; i < args.size(); i++) {
			if (i > 0)
				ret += "|";
			ret += args.get(i).toString();
		}
		return ret;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((args == null) ? 0 : args.hashCode());
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
		ConcreteListArgumentValue other = (ConcreteListArgumentValue) obj;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		return true;
	}
	
	
}
