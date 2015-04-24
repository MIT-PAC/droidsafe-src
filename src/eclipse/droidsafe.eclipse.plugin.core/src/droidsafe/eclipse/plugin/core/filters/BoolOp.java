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

/**
 * An enum type for the boolean operators used to construct a filter.
 * 
 * @author gilham
 *
 */
public enum BoolOp {
    AND(0),
    OR(1);
        
    /**
     * The int value for this boolean operator.
     */
    private int value;

    /**
     * Constructs a BoolOp with the given int value.
     * 
     * @param value - the int value
     */
    private BoolOp(int value) {
            this.value = value;
    }
    
    /**
     * Returns the int value of this boolean operator.
     * 
     * @return the int value
     */
    public int getValue() {
        return value;
    }

    /**
     * The string representation of this BooleanOp.
     */
    @Override
    public String toString() {
        switch (this) {
            case AND: return "and";
            default: return "or";
        }
    }

}
