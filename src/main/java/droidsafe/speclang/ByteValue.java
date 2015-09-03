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
 * A byte constant value in the spec language IR.
 * 
 * @author mgordon
 *
 */
public class ByteValue extends ConcreteArgumentValue {
    /** Internal value */
    private byte value;

    /** Create a new byte value with the given byte value */
    public ByteValue(byte value) {
        this.value = value;
    }
    
    @Override
    public String toStringValue() {
        return "BYTE: " + value;
    }

    public byte getValue() {
        return value;
    }

    /**
     * Return a hex representation of the byte.
     */
    public String toString() {
        return String.format("0x%02X", value);
    }
    
    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ByteValue other = (ByteValue) obj;
        if (value != other.value) return false;
        return true;
    }
    
    
}
