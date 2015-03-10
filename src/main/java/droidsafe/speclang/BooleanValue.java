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

import soot.BooleanType;

public class BooleanValue extends ConcreteArgumentValue {
	private boolean value;
	
	public static BooleanValue TRUE = new BooleanValue(true);
	public static BooleanValue FALSE = new BooleanValue(false);
	
	private BooleanValue(boolean value) {
		super();
		this.value = value;
	}
	
	public static BooleanValue getBooleanValue(int i) {
		return i == 0 ? FALSE : TRUE;
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
