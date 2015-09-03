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

import soot.Type;

/**
 * Class to represented arguments that have been resolved by the JSA analysis
 * into Regular Expressions.
 * 
 * @author mgordon
 *
 */
public class JSAValue extends StringValue {
    /**
     * Create a new JSAValue with the given underlying type, could be
     * String or StringBuilder or CharSequence, etc.
     */
    public JSAValue(String re) {
        super(re);
    }
    
    public String toString() {
        return "STR-RE: \"" + value + "\"";
    }
    
    @Override
    public String toStringValue() {
        return "STR-RE: " + value;
    }
}
