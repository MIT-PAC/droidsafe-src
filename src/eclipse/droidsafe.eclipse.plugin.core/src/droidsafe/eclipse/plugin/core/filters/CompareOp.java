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

package droidsafe.eclipse.plugin.core.filters;

import droidsafe.eclipse.plugin.core.util.DroidsafePluginUtilities;

/**
 * An enum type for the comparison operators used to construct a filter.
 * 
 * @author gilham
 *
 */
public enum CompareOp {
    EQ(0),
    NEQ(1),
    LE(2),
    LT(3),
    GE(4),
    GT(5),
    CONTAINS(6),
    STARTS_WITH(7),
    ENDS_WITH(8);

    /**
     * The string representations of the CompareOp constants.
     */
    public static final String[] strings = DroidsafePluginUtilities.enumStrings(CompareOp.class);

    /**
     * The int value for this comparison operator.
     */
    private int value;

    /**
     * Constructs a CompareOp with the given int value.
     * @param value - the int value
     */
    private CompareOp(int value) {
            this.value = value;
    }
    
    /**
     * Returns the int value of this comparison operator.
     * 
     * @return the int value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the string representation of this CompareOp.
     */
    @Override
    public String toString() {
        switch (this) {
            case EQ: return "=";
            case NEQ: return "!=";
            case LE: return "<=";
            case LT: return "<";
            case GE: return ">=";
            case GT: return ">";
            case CONTAINS: return "contains";
            case STARTS_WITH: return "startsWith";
            default: return "endsWith";
        }
    }
    
    /**
     * Parses the string representation of a CompareOp and returns the CompareOp.
     * 
     * @param str - the string
     * @return the CompareOp corresponds to the string
     * @throws FilterParseException
     */
    public static CompareOp parse(String str) throws FilterParseException {
        for (int i = 0; i < strings.length; i++) {
            if (str.equals(strings[i]))
                return values()[i];
        }
        throw new FilterParseException("Unrecognized compare op: " + str);
    }
    
    /**
     * Applies the comparison operator to the given two boolean values and returns
     * the comparison result.
     * 
     * @param value1 - a boolean value
     * @param value2 - a boolean value
     * @return the comparison result
     */
    public boolean apply(boolean value1, boolean value2) {
        switch (this) {
            case EQ: return value1 == value2;
            case NEQ: return value1 != value2;
            default: return false;
        }
    }

    /**
     * Applies the comparison operator to the given two int values and returns
     * the comparison result.
     * 
     * @param value1 - an int value
     * @param value2 - an int value
     * @return the comparison result
     */
    public boolean apply(int value1, int value2) {
        switch (this) {
            case EQ: return value1 == value2;
            case NEQ: return value1 != value2;
            case LE: return value1 <= value2;
            case LT: return value1 < value2;
            case GE: return value1 >= value2;
            case GT: return value1 > value2;
            default: return false;
        }
    }

    /**
     * Applies the comparison operator to the given two string values and returns
     * the comparison result.
     * 
     * @param value1 - an string value
     * @param value2 - an string value
     * @return the comparison result
     */
    public boolean apply(String value1, String value2) {
        switch (this) {
            case EQ: return value1.equals(value2);
            case NEQ: return !value1.equals(value2);
            case CONTAINS: return value1.contains(value2);
            case STARTS_WITH: return value1.startsWith(value2);
            case ENDS_WITH: return value1.endsWith(value2);
            default: return false;
        }
    }
}
