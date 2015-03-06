/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.speclang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.RefType;
import soot.Type;

import droidsafe.android.app.Project;

/**
 * This class represents possible values for arguments to output and input events 
 * including types, concrete values, or any value. 
 * 
 * There two types here, the type of the argument: type, any, concretelist
 * 
 * And the type of the underlying value: class (if type), void if any, 
 * primitive type of the concretelist.  The underlying type is represented by a string
 * 
 * @author mgordon
 *
 */
public abstract class ArgumentValue {
	private static final Logger logger = LoggerFactory.getLogger(ArgumentValue.class);
	
	protected Type type;
	
	public ArgumentValue(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public boolean isConcreteList() {
		return this instanceof ConcreteListArgumentValue;
	}
	
	public boolean isType() {
		return this instanceof TypeValue;
	}
	
	/**
	 * Combine arguments from different occurrences of the same method is an intelligent way.
	 * 
	 * For example, any value combined with a concrete value will be an any value.
	 * 
	 * @param val1
	 * @param val2
	 * @return the combined argument value.
	 */
	public static ArgumentValue combine(ArgumentValue val1, ArgumentValue val2, Type actualArgumentType) {
		if (!val1.getType().equals(val2.getType())) {
			return new TypeValue(actualArgumentType);
		}
		
		ArgumentValue ret;
		if (val1.isConcreteList() && val2.isConcreteList()) {
			ret = ConcreteListArgumentValue.combine((ConcreteListArgumentValue)val1, 
													(ConcreteListArgumentValue)val2, actualArgumentType);
		} else if (val1.isConcreteList())
			ret = val2;
		else if (val2.isConcreteList())
			ret = val1;
		else {
			if (!(val1.isType() && val2.isType())) {
			    logger.error("Trying to combine unknown Types {} ({}) != {} ({})", 
			        val1.getType(), val2, val2.getType());
				droidsafe.main.Main.exit(1);
			}
			ret = val1;
		}
		return ret;
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
		ArgumentValue other = (ArgumentValue) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
