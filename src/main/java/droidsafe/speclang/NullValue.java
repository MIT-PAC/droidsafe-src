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

/**
 * This class represents the null constant value in Java.
 * 
 * @author mgordon
 *
 */
public class NullValue extends ConcreteArgumentValue {
    /** static singleton because there only needs to be one null value */
    private static NullValue singleton = new NullValue();
    
    /**
     * Create a new null Value.
     */
    private NullValue() {
   
    }
    
    /**
     * Return the singleton null value.
     */
    public static NullValue getNullValue() {
        return singleton;
    }

    /**
     * Return string.
     */
    @Override
    public String toStringValue() {
        return "null";
    }
    
    /**
     * Return string.
     */
    public String toString() {
        return "null";
    }

}
